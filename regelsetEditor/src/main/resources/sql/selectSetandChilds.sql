select * from re_regelset;

select * from re_regel_konf where regelset_id = 200000;

select * from re_regel_def where id in (select re_regel_konf.regel_def_id from re_regel_konf where regelset_id = 200000);

select * from re_regel_param where regel_konf_id in (select id from re_regel_konf where regelset_id = 200000);

select * from re_regel_param_def where regel_def_id in (select id from re_regel_def where id in (select re_regel_konf.regel_def_id from re_regel_konf where regelset_id = 200000));
