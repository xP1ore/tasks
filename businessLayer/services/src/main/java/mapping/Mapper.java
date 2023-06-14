package mapping;


public interface Mapper<Entity, InputDto, OutputDto> extends
        ToEntityMapper<Entity, InputDto>,
        ToOutputMapper<Entity, OutputDto>{
}
