create or replace table game(
    id int auto_increment primary key not null,
    game_name varchar(256) not null
);

create or replace table category(
    id int auto_increment primary key not null,
    category_name varchar(256) not null,
    game_id int not null,
    constraint fk_game_category
        foreign key (game_id) references game (id) on delete cascade on update restrict
)

create or replace table question(
    id int auto_increment primary key not null,
    text varchar(256) not null,
    worth int not null,
    category_id int not null,
    constraint fk_category_question
        foreign key (category_id) references category (id) on delete cascade on update restrict
);