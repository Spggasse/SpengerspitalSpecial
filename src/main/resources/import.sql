set foreign_key_checks = off;

INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`, `p_gender`, `p_deceasedBoolean`) VALUES ('abc123', 1, '2000-01-01', 'unknown', 0);
INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`, `p_gender`, `p_deceasedBoolean`) VALUES ('xyz987', 0, '2001-04-05', 'male', 0);
INSERT INTO `spengerspital`.`p_patient` (`id`, `p_active`, `p_birthdate`, `p_gender`, `p_deceasedBoolean`) VALUES ('dreck468', 1, '2002-07-09', 'other', 0);

INSERT INTO `spengerspital`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('123123', 'text ;-)');
INSERT INTO `spengerspital`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('123', 'text ;--))');

INSERT INTO `spengerspital`.`i_identifier` (`id`, `i_code`, `pe_ende`, `pe_start`, `i_system`, `i_value`, `i_codeableconcept_fk`, `i_patient_fk`) VALUES ('id123', 'secondary', '2020-02-02', '2020-01-01', 'http://url', '1234010180', '123', 'dreck468');

INSERT INTO `spengerspital`.`a_address` (`id`, `a_city`, `a_country`, `a_district`, `pe_ende`, `pe_start`, `a_postalcode`, `a_state`, `a_text`, `a_usetype`, `a_usecode`, `a_patient_fk`) VALUES ('id1', 'Vienna', 'Austria', '5', '2020-02-02', '2020-01-01', '1050', 'Vienna', 'TextAdresse123', 'postal', 'home', 'abc123');
INSERT INTO `spengerspital`.`a_address` (`id`, `a_city`, `a_country`, `a_district`, `pe_ende`, `pe_start`, `a_postalcode`, `a_state`, `a_text`, `a_usetype`, `a_usecode`, `a_patient_fk`) VALUES ('id2', 'Hartberg', 'Austria', '6', '2020-04-05', '2019-12-19', '2574', 'Styria', 'TextAdresseidk', 'both', 'old', 'abc123');

INSERT INTO `spengerspital`.`at_attachment` (`id`, `at_contenttype`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_title`, `at_url`, `at_patient_fk`) VALUES ('id001', 'contentHALLO', '2019-12-17', 'QjBCQUVFOUQyNzlEMzRGQTFERkQ3MUFBREI5MDhDM0Y=', 'hashWOOHOOOO', 'german', '34', 'TITEL:)', 'https://dreck.com', 'xyz987');

INSERT INTO `spengerspital`.`cp_contactpoint` (`id`, `pe_ende`, `pe_start`, `cp_rank`, `cp_system`, `cp_use`, `cp_value`, `cp_patient_fk`) VALUES ('idCP1', '2020-08-08', '2020-08-01', '2', 'fax', 'work', 'VaLuE', 'abc123');
INSERT INTO `spengerspital`.`cp_contactpoint` (`id`, `pe_ende`, `pe_start`, `cp_rank`, `cp_system`, `cp_use`, `cp_value`, `cp_patient_fk`) VALUES ('idCP2', '2020-01-01', '2019-05-03', '1', 'pager', 'work', 'vAlUe', 'xyz987');

INSERT INTO `spengerspital`.`hn_humanname` (`id`, `hn_family`, `pe_ende`, `pe_start`, `hn_text`, `hn_nameusecode`, `hn_patient_fk`) VALUES ('idHN1', 'Stäbler', '2020-06-08', '2020-01-01', 'TTEEXXTT', 'usual', 'abc123');


INSERT INTO `spengerspital`.`i_identifier` (`id`, `i_code`, `pe_ende`, `pe_start`, `i_system`, `i_value`, `i_codeableconcept_fk`, `i_patient_fk`, `i_encounter_fk`) VALUES ('idNEU', 'secondary', '2020-03-03', '2020-01-01', 'http://url', 'VALUE:)', '123', 'abc123', 'encounterid');


INSERT INTO `spengerspital`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_user_selected`, `c_version`, `c_codeableconcept_fk`) VALUES ('id für plf woohoo', 'CODE', 'DISPLAY', 'SYSTEM', 1, 'VERSION', '123 text ;--))');


INSERT INTO `spengerspital`.`e_encounter` (`id`, `e_length`, `pe_ende`, `pe_start`, `e_status`, `e_coding_fk`) VALUES ('encounterid', '2 weeks', '2020-01-31', '2020-01-20', 'planned', 'id für plf woohoo');


--INSERT INTO `spengerspital`.`pr_practicioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`, `pe_ende`, `pe_start`, `qu_codeableconcept_fk`) VALUES ('prac1', 0, '1980-12-31', 'male', '2020-01-01', '2020-02-01', 'cc1');

INSERT INTO `spengerspital`.`pr_practicioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`, `pe_ende`, `pe_start`) VALUES ('prac1', 0, '1980-12-31', 'male', '2020-01-01', '2020-02-01');


