package me.nootnoot.mctiersadminbackend.controller.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class GetAllNamesAndUuidsResponse implements Serializable {
    private List<NameAndUuid> nameAndUuids;
}
