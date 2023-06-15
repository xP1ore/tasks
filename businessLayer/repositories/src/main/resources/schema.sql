create database myDB;

create table if not exists employee (
    id                  serial primary key,
    firstName           varchar(50) not null,
    lastName            varchar(50) not null,
    employeeStatus      varchar(50) not null,
    emailAddress        varchar(50)
);

create table if not exists project (
    id                      serial primary key,
    projectCode             int not null unique,
    projectName             varchar(50) not null,
    projectStatus           varchar(50) not null
    projectDescription      varchar(255)
);

create table if not exists task (
    id              serial primary key,
    taskName        varchar(50) not null,
    taskStatus      varchar(50) not null,
    dateCreated     timestamp not null,
    dateUpdated     timestamp not null,
    taskDeadline    timestamp not null,
    fkExecutorId    bigint,
    taskLabor       int not null check (taskLabor > 0),
    fkAuthorId      int not null,
    constraint  fkAuthorId foreign key (fkAuthorId) references employee (id),
    constraint fkExecutorId foreign key (fkExecutorId) references employee (id)
);

create table if not exists projectTeam (
    id                  serial primary key,
    fkProjectId         bigint not null,
    fkEmployeeId        bigint not null,
    projectMemberRole   varchar(50) not null,
    constraint fkProjectId foreign key (fkProjectId) references project (id),
    constraint fkEmployeeId foreign key (fkEmployeeId) references employee (id)
);