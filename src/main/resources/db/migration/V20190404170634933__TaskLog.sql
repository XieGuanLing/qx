    create table sm_task_log (
       task_log_id bigint not null auto_increment,
        date_created datetime,
        deleted datetime,
        imported datetime,
        last_updated datetime,
        finished bit not null,
        type integer not null,
        work_day date not null,
        primary key (task_log_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

