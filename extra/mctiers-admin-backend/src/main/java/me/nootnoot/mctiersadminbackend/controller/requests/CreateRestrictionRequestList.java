package me.nootnoot.mctiersadminbackend.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestrictionRequestList implements Serializable {
    private List<CreateRestrictionRequest> requests;
}
