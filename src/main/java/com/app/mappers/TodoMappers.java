package com.app.mappers;

import com.app.dto.TaskDto;
import com.app.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TodoMappers {

    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "status", source = "taskStatus")
    Task mapTaskDtoToEntity(TaskDto taskDto);
}
