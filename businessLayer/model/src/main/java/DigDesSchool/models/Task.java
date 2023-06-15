package DigDesSchool.models;

import DigDesSchool.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Data
@Table(name = "Task")
public class Task implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskIdSequence")
    private Long id;

    @Column(name = "taskName", nullable = false)
    private String taskName;

    @Column(name = "taskStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated; // дата создания задачи

    @Column(name = "dateUpdated", nullable = false)
    private Date dateUpdated; // дата изменения задачи

    @Column(name = "taskDeadline", nullable = false)
    private Date taskDeadline; // крайний срок исполнения (нельзя выбрать, если < дата создания + трудозатраты)

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkExecutorId")
    private Employee executor; // испольнитель задачи

    @Column(name = "taskLabor", nullable = false)
    private Long taskLabor; // трудозатраты на задачу в часах

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkAuthorId", nullable = false)
    private Employee author; // автор задачи

}
