package models;

import enums.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class Task implements Serializable {
    private Long id;
    private TaskStatus taskStatus;
    private Date dateUpdated; // дата изменения задачи
    private Date dateCreated; // дата создания задачи
    private String taskName;
    private Employee author; // автор задачи
    private Employee executor; // испольнитель задачи
    private Long taskLabor; // трудозатраты на задачу в часах
    private Date taskDeadline; // крайний срок исполнения (нельзя выбрать, если < дата создания + трудозатраты)
}
