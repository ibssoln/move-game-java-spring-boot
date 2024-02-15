package com.priceline.chutes.dto.chutesladder;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ChutesLadderRequest {

    //NOTE: Added this data transfer object to be used as a RequestBody for a chutes and ladder game play.

    private String[] playerNames;

}
