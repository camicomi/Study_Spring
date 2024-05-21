-- spring

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);

create sequence seqAddress;
drop sequence seqAddress;

insert into tblAddress values (seqAddress.nextVal, 'È«ï¿½æµ¿', 20, 'ï¿½ï¿½ï¿½ï¿½ï¿?', 'm');

select * from tblAddress;



insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½', 3, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ïµ¿ ï¿½Ñµï¿½ï¿½ï¿½ï¿½ï¿½ 8ï¿½ï¿½', 'm');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½', 2, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ïµ¿ ï¿½Ñµï¿½ï¿½ï¿½ï¿½ï¿½ 3ï¿½ï¿½', 'f');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½ï¿½Æ¸ï¿½', 1, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ïµ¿ ï¿½Ñµï¿½ï¿½ï¿½ï¿½ï¿½ 2ï¿½ï¿½', 'f');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½ï¿½ï¿½', 7, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Ä¡ï¿½ï¿½', 'm');
insert into tblAddress values (seqAddress.nextVal, 'È£ï¿½ï¿½ï¿½ï¿½', 6, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ð±ï¿½ï¿½ï¿½ï¿½ï¿½', 'f');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½Ñ±ï¿?', 3, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ÃµÈ£ï¿½ï¿½', 'f');
insert into tblAddress values (seqAddress.nextVal, 'Å¸ï¿½ï¿½', 4, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ï»çµ¿', 'm');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½Ü½ï¿½ï¿½ï¿½', 1, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½Ï±ï¿½ ï¿½ï¿½ï¿½Ìµï¿½', 'm');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½Å¸', 5, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½Ï±ï¿½ ï¿½ï¿½ï¿½ï¿½', 'm');
insert into tblAddress values (seqAddress.nextVal, 'ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½', 3, 'ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½Ï±ï¿½ ï¿½Ì¾Æµï¿½', 'm');


create table tblUser (
    seq number primary key,
    name varchar2(30) not null
);

create sequence seqUser;

create table tblDetail (
    seq number primary key,
    email varchar2(100) not null,
    user_seq number not null references tblUser(seq)
);

create sequence seqDetail;


create table tblInfo (
	seq number,
	school varchar2(100) not null,
	country varchar2(100) not null,
	
	constraint info_pk primary key(seq),
	constraint info_kf foreign key(seq) references tblAddress(seq) 
);

insert into tblInfo values (1, '°­³² µ¿¹°ÇÐ±³', '´ëÇÑ¹Î±¹');
insert into tblInfo values (2, '°­³² µ¿¹°ÇÐ±³', '´ëÇÑ¹Î±¹');
insert into tblInfo values (3, '´º¿å ¾ÆÄ«µ¥¹Ì', '¹Ì±¹');
insert into tblInfo values (4, 'µ¿°æ ÈÆ·Ã¿ø', 'ÀÏº»');
insert into tblInfo values (5, 'º£ÀÌÂ¡ ÈÆ·Ã¼Ò', 'Áß±¹');

create table tblMemo (
	seq number primary key,
	memo varchar2(500) not null,
	regdate date default sysdate not null,
	aseq number not null references tblAddress(seq) 
);

create sequence seqMemo;

insert into tblMemo values (seqMemo.nextVal, '¾È³çÇÏ¼¼¿ä.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '³¯¾¾°¡ Á¶±Ý Èå·Á¿ä.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '¿ù¿äÀÏÀÔ´Ï´Ù.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '½ºÇÁ¸µ °øºÎÇÏ°í ÀÖ¾î¿ä.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '¹ú½á ¹è°¡ °íÆÄ¿ä.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '¿À´Ãµµ ¿­½ÉÈ÷ ³·Àá Áß', default, 2);
insert into tblMemo values (seqMemo.nextVal, 'Áý»ç¾ß ¹ä³»³ö¶ó!', default, 2);
insert into tblMemo values (seqMemo.nextVal, '»ß¾à»ß¾à', default, 3);
insert into tblMemo values (seqMemo.nextVal, '±¸±¸', default, 6);
insert into tblMemo values (seqMemo.nextVal, 'ÇÏ´ÃÀ» ³¯´Ù.', default, 9);
insert into tblMemo values (seqMemo.nextVal, 'ÁýÀÌ Á¼¾Æ¿ä.', default, 8);



-- tblAddress : tblInfo
-- 1 : 1 > join

-- tblAddress : tblMemo
-- 1 : N > join

-- tblAddress
select * from tblAddress;

-- tblInfo
select * from tblInfo;

-- tblMemo
-- ASEQ  == AddressSeq
select * from tblMemo; 

select * from tblAddress a left outer join tblInfo i on a.seq = i.seq;
select * from tblAddress a inner join tblInfo i on a.seq = i.seq;

select * from tblAddress a
    left outer join tblMemo m
        on a.seq = m.aseq;

commit;

