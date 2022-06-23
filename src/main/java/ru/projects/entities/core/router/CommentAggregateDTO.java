package ru.projects.entities.core.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.projects.entities.EntityData;
import ru.projects.entities.core.personal.dto.GeneralDataUsersPersDto;
import ru.projects.entities.uni.RatingData;
import ru.projects.entities.uni.comments.CommentData;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentAggregateDTO extends EntityData {

    private RatingData rating;
    private Map<CommentData, Map.Entry<GeneralDataUsersPersDto, RatingData>> comments;

}
