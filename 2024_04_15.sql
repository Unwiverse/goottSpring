create table pc(
    pnum number primary key,
    cpu varchar2(20) not null,
    mainboard varchar2(20) not null,
    vga varchar2(20),
    ram varchar2(30) not null,
    ssd varchar2(20) not null,
    hdd varchar2(20),
    psu varchar2(20) not null,
    os varchar2(10) not null
    );
    alter table pc
    add cpu_cooler varchar2(20);
    alter table pc
    add case varchar2(20);
    