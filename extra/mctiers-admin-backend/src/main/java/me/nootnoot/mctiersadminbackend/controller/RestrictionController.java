package me.nootnoot.mctiersadminbackend.controller;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.controller.requests.CreateRestrictionRequest;
import me.nootnoot.mctiersadminbackend.controller.requests.CreateRestrictionRequestList;
import me.nootnoot.mctiersadminbackend.controller.responses.GetAllNamesAndUuidsResponse;
import me.nootnoot.mctiersadminbackend.controller.responses.NameAndUuid;
import me.nootnoot.mctiersadminbackend.managers.RestrictionsManager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restrictions")
@RequiredArgsConstructor
public class RestrictionController {

    private final RestrictionsManager restrictionsManager;

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void restrict(@Validated @RequestBody CreateRestrictionRequestList requestList){
        for(CreateRestrictionRequest request : requestList.getRequests()) {
            System.out.println("name: " + request.getUsername());
            System.out.println("uuid: " + request.getUuid());
            restrictionsManager.restrict(request.getUsername(), request.getDuration(), request.getReason(), request.getBanStatement(), request.getUuid());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public GetAllNamesAndUuidsResponse getAll(){
        System.out.println("getting all");
        return new GetAllNamesAndUuidsResponse(restrictionsManager.getAllUsernameAndUuids());
    }

}
