package mapping;


// мап входящих данный к сущностям в системе
public interface ToEntityMapper<Entity, InputDto> {
    Entity mapToEntity(InputDto inputDto);
}
