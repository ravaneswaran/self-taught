/*==============================================================================*/
/* Clear all tables: */
/*==============================================================================*/

IF OBJECT_ID('QRTZ_FIRED_TRIGGERS') IS NOT NULL
delete from QRTZ_FIRED_TRIGGERS
go
IF OBJECT_ID('QRTZ_PAUSED_TRIGGER_GRPS') IS NOT NULL
delete from QRTZ_PAUSED_TRIGGER_GRPS
go
IF OBJECT_ID('QRTZ_SCHEDULER_STATE') IS NOT NULL
delete from QRTZ_SCHEDULER_STATE
go
IF OBJECT_ID('QRTZ_LOCKS') IS NOT NULL
delete from QRTZ_LOCKS
go
IF OBJECT_ID('QRTZ_SIMPLE_TRIGGERS') IS NOT NULL
delete from QRTZ_SIMPLE_TRIGGERS
go
IF OBJECT_ID('QRTZ_SIMPROP_TRIGGERS') IS NOT NULL
delete from QRTZ_SIMPROP_TRIGGERS
go
IF OBJECT_ID('QRTZ_CRON_TRIGGERS') IS NOT NULL
delete from QRTZ_CRON_TRIGGERS
go
IF OBJECT_ID('QRTZ_BLOB_TRIGGERS') IS NOT NULL
delete from QRTZ_BLOB_TRIGGERS
go
IF OBJECT_ID('QRTZ_TRIGGERS') IS NOT NULL
delete from QRTZ_TRIGGERS
go
IF OBJECT_ID('QRTZ_JOB_DETAILS') IS NOT NULL
delete from QRTZ_JOB_DETAILS
go
IF OBJECT_ID('QRTZ_CALENDARS') IS NOT NULL
delete from QRTZ_CALENDARS
go

/*==============================================================================*/
/* Drop constraints: */
/*==============================================================================*/

alter table QRTZ_TRIGGERS
drop constraint FK_triggers_job_details
go

alter table QRTZ_CRON_TRIGGERS
drop constraint FK_cron_triggers_triggers
go

alter table QRTZ_SIMPLE_TRIGGERS
drop constraint FK_simple_triggers_triggers
go

alter table QRTZ_SIMPROP_TRIGGERS
drop constraint FK_simprop_triggers_triggers
go

alter table QRTZ_BLOB_TRIGGERS
drop constraint FK_blob_triggers_triggers
go

/*==============================================================================*/
/* Drop tables: */
/*==============================================================================*/

drop table QRTZ_FIRED_TRIGGERS
go
drop table QRTZ_PAUSED_TRIGGER_GRPS
go
drop table QRTZ_SCHEDULER_STATE
go
drop table QRTZ_LOCKS
go
drop table QRTZ_SIMPLE_TRIGGERS
go
drop table QRTZ_SIMPROP_TRIGGERS
go
drop table QRTZ_CRON_TRIGGERS
go
drop table QRTZ_BLOB_TRIGGERS
go
drop table QRTZ_TRIGGERS
go
drop table QRTZ_JOB_DETAILS
go
drop table QRTZ_CALENDARS
go
