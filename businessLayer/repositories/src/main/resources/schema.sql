create database myDB;

create table employee (
    id                  serial primary key,
    firstName           varchar(50) not null,
    lastName            varchar(50) not null,
    employeeStatus      varchar(50) not null,
    emailAddress        varchar(50)
);

create table project (
    id                      serial primary key,
    projectCode             varchar(50) not null unique,
    projectName             varchar(50) not null,
    projectStatus           varchar(50) not null
    projectDescription      varchar(255)
);

create table task (
    id              serial primary key,
    taskName        varchar(50) not null,
    taskStatus      varchar(50) not null,
    dateCreated     timestamp not null,
    dateUpdated     timestamp not null,
    fkExecutorId    int,
    taskLabor       int not null check (taskLabor > 0),
    fkAuthorId      int not null,
    constraint  fkAuthorId foreign key (fkAuthorId) references employee (id),
    constraint fkExecutorId foreign key (fkExecutorId) references employee (id)
);

create table projectTeam (
    id                  serial primary key,
    fkProjectId         int not null,
    fkEmployeeId        int not null,
    projectMemberRole   varchar(50) not null,
    constraint fkProjectId foreign key (fkProjectId) references project (id),
    constraint fkEmployeeId foreign key (fkEmployeeId) references employee (id)
);