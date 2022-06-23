alter table bucket_list add type varchar(10);
update bucket_list set type = 'PUBLIC';
INSERT INTO public.bucket_list (bucket, type) VALUES ('coop152-dev-data', 'PRIVATE');
INSERT INTO public.bucket_list (bucket, type) VALUES ('coop-dev-data', 'PUBLIC');
INSERT INTO public.bucket_list (bucket, type) VALUES ('uat-data', 'PUBLIC');