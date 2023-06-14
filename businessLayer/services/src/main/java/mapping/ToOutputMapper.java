package mapping;

// мап обработанных данных для вывода
public interface ToOutputMapper<Entity, OutputDto> {
    OutputDto mapToOutput(Entity entity);
}
