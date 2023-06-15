package DigDesSchool.mapping;

public interface EntityMapper<Entity, InputDto, OutputDto, ModifyEntityDto> {

    public Entity mapToEntity(InputDto newEntity);
    public OutputDto mapToOutput(Entity entity);
    public Entity mapModifyEntityDto(ModifyEntityDto entityToModify);
    public Entity updateNonNullFields(Entity source, Entity target) throws IllegalAccessException;

}
