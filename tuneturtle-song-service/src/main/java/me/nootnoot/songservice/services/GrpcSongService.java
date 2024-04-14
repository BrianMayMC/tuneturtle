package me.nootnoot.songservice.services;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import me.nootnoot.songservice.generated.Song;
import me.nootnoot.songservice.generated.songGrpc;
import me.nootnoot.songservice.managers.SongManager;

public class GrpcSongService extends songGrpc.songImplBase {
    private final SongManager songManager = new SongManager();

    @Override
    public void getSongById(Song.GetRequest request, StreamObserver<Song.SongDTO> responseObserver) {
        me.nootnoot.songservice.entities.Song song = songManager.getSongById(request.getSongId());

        responseObserver.onNext(Song.SongDTO.newBuilder()
                .setSongId(song.getSongId())
                .setName(song.getName())
                .setArtistId(song.getArtistId())
                .setIconImage(song.getIconImage())
                .setSongData(ByteString.copyFrom(song.getSongData()))
                .setListenAmount(song.getListenAmount())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void addSong(Song.SongDTO request, StreamObserver<Song.Empty> responseObserver) {
        me.nootnoot.songservice.entities.Song song = new me.nootnoot.songservice.entities.Song(request.getSongId(),
                request.getName(), request.getArtistId(), request.getIconImage(), request.getSongData().toByteArray());
        songManager.addSong(song);

        responseObserver.onNext(Song.Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteSong(Song.DeleteRequest request, StreamObserver<Song.Empty> responseObserver) {
        songManager.deleteSong(request.getSongId());

        responseObserver.onNext(Song.Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getListenAmount(Song.GetRequest request, StreamObserver<Song.ListenAmountDTO> responseObserver) {
        responseObserver.onNext(Song.ListenAmountDTO.newBuilder()
                .setListenAmount(songManager.getListenAmount(request.getSongId())).build());
        responseObserver.onCompleted();
    }

    @Override
    public void addListenAmount(Song.GetRequest request, StreamObserver<Song.Empty> responseObserver) {
        songManager.addListen(request.getSongId());
        responseObserver.onNext(Song.Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
