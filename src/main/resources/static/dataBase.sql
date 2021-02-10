CREATE TABLE "type_group_question" (
  "id_type_group_question" BIGSERIAL PRIMARY KEY,
  "description" varchar(50) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp
);

CREATE TABLE "group_question" (
  "id_group_question" BIGSERIAL PRIMARY KEY,
  "id_type_group_question" bigint,
  "description" varchar(100) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp,
  "active" boolean NOT NULL
);

CREATE TABLE "group_question_rule" (
  "id_group_question_rule" BIGSERIAL PRIMARY KEY,
  "id_group_question" bigint,
  "id_question_type" bigint,
  "description_question" varchar(200) NOT NULL
);

CREATE TABLE "question_type" (
  "id_question_type" BIGSERIAL PRIMARY KEY,
  "description" varchar(50) NOT NULL
);

CREATE TABLE "question" (
  "id_question" BIGSERIAL PRIMARY KEY,
  "id_question_type" bigint,
  "description" varchar(200) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp
);

CREATE TABLE "response" (
  "id_response" BIGSERIAL PRIMARY KEY,
  "id_question" bigint,
  "description" varchar(100) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp
);

CREATE TABLE "rule_response" (
  "id_rule_response" BIGSERIAL PRIMARY KEY,
  "id_group_rule_father" bigint,
  "id_group_rule_son" bigint,
  "id_report" bigint,
  "id_type_route" bigint,
  "description_response" varchar(50) NOT NULL
);

CREATE TABLE "rule_question" (
  "id_rule_question" BIGSERIAL PRIMARY KEY,
  "id_group_rule_father" bigint,
  "id_group_rule_son" bigint,
  "id_type_route" bigint
);

CREATE TABLE "report" (
  "id_report" BIGSERIAL PRIMARY KEY,
  "description" varchar(50) NOT NULL
);

CREATE TABLE "response_label" (
  "id_rule_response" bigint,
  "id_label" bigint
);

CREATE TABLE "label" (
  "id_label" BIGSERIAL PRIMARY KEY,
  "description" varchar(50) NOT NULL
);

CREATE TABLE "type_route_ENUM" (
  "id_type_route" BIGSERIAL PRIMARY KEY,
  "description" varchar(50)
);

CREATE TABLE "demandant" (
  "id_demandant" BIGSERIAL PRIMARY KEY,
  "user" varchar(10) NOT NULL,
  "nome" varchar(200) NOT NULL
);

CREATE TABLE "group_question_answered" (
  "id_group_question_answered" BIGSERIAL PRIMARY KEY,
  "id_demandant" bigint,
  "id_group_question" bigint,
  "date_creation" timestamp NOT NULL,
  "date_update" timestamp NOT NULL
);

CREATE TABLE "question_answered" (
  "id_question_answered" BIGSERIAL PRIMARY KEY,
  "id_group_question_answered" bigint,
  "id_rule_response" bigint,
  "description" varchar(300) NOT NULL
);

CREATE TABLE "type_parameter" (
  "id_type_parameter" BIGSERIAL PRIMARY KEY,
  "description" varchar(50) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp
);

CREATE TABLE "parameter" (
  "id_parameter" BIGSERIAL PRIMARY KEY,
  "id_type_parameter" bigint,
  "description" varchar(50) NOT NULL,
  "user_creation" varchar(10) NOT NULL,
  "date_creation" timestamp NOT NULL,
  "user_update" varchar(10),
  "date_update" timestamp
);

CREATE TABLE "group_question_answered_parameter" (
  "id_parameter" bigint,
  "id_group_question_answered" bigint
);

ALTER TABLE "group_question" ADD FOREIGN KEY ("id_type_group_question") REFERENCES "type_group_question" ("id_type_group_question");

ALTER TABLE "group_question_rule" ADD FOREIGN KEY ("id_group_question") REFERENCES "group_question" ("id_group_question");

ALTER TABLE "group_question_rule" ADD FOREIGN KEY ("id_question_type") REFERENCES "question_type" ("id_question_type");

ALTER TABLE "question" ADD FOREIGN KEY ("id_question_type") REFERENCES "question_type" ("id_question_type");

ALTER TABLE "response" ADD FOREIGN KEY ("id_question") REFERENCES "question" ("id_question");

ALTER TABLE "rule_response" ADD FOREIGN KEY ("id_group_rule_father") REFERENCES "group_question_rule" ("id_group_question_rule");

ALTER TABLE "rule_response" ADD FOREIGN KEY ("id_group_rule_son") REFERENCES "group_question_rule" ("id_group_question_rule");

ALTER TABLE "rule_response" ADD FOREIGN KEY ("id_report") REFERENCES "report" ("id_report");

ALTER TABLE "rule_response" ADD FOREIGN KEY ("id_type_route") REFERENCES "type_route_ENUM" ("id_type_route");

ALTER TABLE "rule_question" ADD FOREIGN KEY ("id_group_rule_father") REFERENCES "group_question_rule" ("id_group_question_rule");

ALTER TABLE "rule_question" ADD FOREIGN KEY ("id_group_rule_son") REFERENCES "group_question_rule" ("id_group_question_rule");

ALTER TABLE "rule_question" ADD FOREIGN KEY ("id_type_route") REFERENCES "type_route_ENUM" ("id_type_route");

ALTER TABLE "response_label" ADD FOREIGN KEY ("id_rule_response") REFERENCES "rule_response" ("id_rule_response");

ALTER TABLE "response_label" ADD FOREIGN KEY ("id_label") REFERENCES "label" ("id_label");

ALTER TABLE "group_question_answered" ADD FOREIGN KEY ("id_demandant") REFERENCES "demandant" ("id_demandant");

ALTER TABLE "group_question_answered" ADD FOREIGN KEY ("id_group_question") REFERENCES "group_question" ("id_group_question");

ALTER TABLE "question_answered" ADD FOREIGN KEY ("id_group_question_answered") REFERENCES "group_question_answered" ("id_group_question_answered");

ALTER TABLE "question_answered" ADD FOREIGN KEY ("id_rule_response") REFERENCES "rule_response" ("id_rule_response");

ALTER TABLE "parameter" ADD FOREIGN KEY ("id_type_parameter") REFERENCES "type_parameter" ("id_type_parameter");

ALTER TABLE "group_question_answered_parameter" ADD FOREIGN KEY ("id_parameter") REFERENCES "parameter" ("id_parameter");

ALTER TABLE "group_question_answered_parameter" ADD FOREIGN KEY ("id_group_question_answered") REFERENCES "group_question_answered" ("id_group_question_answered");
