

CREATE TABLE public.escenario (
    id integer NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.escenario OWNER TO neondb_owner;

--
-- TOC entry 218 (class 1259 OID 24583)
-- Name: movimiento; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.movimiento (
    id integer NOT NULL,
    nombre text NOT NULL,
    abreviatura character varying NOT NULL
);


ALTER TABLE public.movimiento OWNER TO neondb_owner;

--
-- TOC entry 219 (class 1259 OID 24588)
-- Name: personaje; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.personaje (
    id integer NOT NULL,
    echo integer NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.personaje OWNER TO neondb_owner;

--
-- TOC entry 220 (class 1259 OID 24591)
-- Name: personaje2; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.personaje2 (
    id integer NOT NULL,
    echo integer NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.personaje2 OWNER TO neondb_owner;

--
-- TOC entry 221 (class 1259 OID 24594)
-- Name: personaje2_id_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.personaje2_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.personaje2_id_seq OWNER TO neondb_owner;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 221
-- Name: personaje2_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.personaje2_id_seq OWNED BY public.personaje2.id;


--
-- TOC entry 222 (class 1259 OID 24595)
-- Name: posicion; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.posicion (
    id integer NOT NULL,
    nombre text NOT NULL
);


ALTER TABLE public.posicion OWNER TO neondb_owner;

--
-- TOC entry 223 (class 1259 OID 24600)
-- Name: registro; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.registro (
    id integer NOT NULL,
    idpersonajeemisor integer NOT NULL,
    idpersonajereceptor integer NOT NULL,
    idmovimiento integer NOT NULL,
    idescenario integer NOT NULL,
    idposicion integer NOT NULL,
    porcentajeko integer NOT NULL,
    rage integer,
    di boolean
);


ALTER TABLE public.registro OWNER TO neondb_owner;

--
-- TOC entry 3207 (class 2604 OID 24603)
-- Name: personaje2 id; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.personaje2 ALTER COLUMN id SET DEFAULT nextval('public.personaje2_id_seq'::regclass);



INSERT INTO public.escenario (id, nombre) VALUES
(1, 'Final Destination'),
(2, 'Battlefield'),
(3, 'Small Battlefield'),
(4, 'Pokemon Stadium 2'),
(5, 'Smashville'),
(6, 'Town and City'),
(7, 'Kalos Pokemon League'),
(8, 'Hollow Bastion');


INSERT INTO public.movimiento (id, nombre, abreviatura) VALUES
(1, 'Jab', 'Jab'),
(2, 'Forward Tilt', 'F-Tilt'),
(3, 'Up Tilt', 'U-Tilt'),
(4, 'Down Tilt', 'D-Tilt'),
(5, 'Dash Attack', 'D-Attack'),
(6, 'Forward Smash', 'F-Smash'),
(7, 'Up Smash', 'U-Smash'),
(8, 'Down Smash', 'D-Smash'),
(9, 'Neutral Air', 'N-Air'),
(14, 'Neutral Special', 'N-Special'),
(15, 'Side Special', 'S-Special'),
(16, 'Up Special', 'U-Special'),
(17, 'Down Special', 'D-Special'),
(10, 'Forward Air', 'F-Air'),
(11, 'Back Air', 'B-Air'),
(12, 'Up Air', 'A-Air'),
(13, 'Down Air', 'D-Air');



INSERT INTO public.personaje (id, echo, nombre) VALUES
(1, 1, 'Mario'),
(2, 1, 'Donkey Kong'),
(3, 1, 'Link'),
(4, 1, 'Samus'),
(5, 1, 'Yoshi'),
(6, 1, 'Kirby'),
(7, 1, 'Fox'),
(8, 1, 'Pikachu'),
(9, 1, 'Luigi'),
(10, 1, 'Ness'),
(11, 1, 'Captain Falcon'),
(12, 1, 'Jigglypuff'),
(13, 1, 'Peach'),
(14, 1, 'Bowser'),
(15, 1, 'Ice Climbers'),
(16, 1, 'Sheik'),
(17, 1, 'Zelda'),
(18, 1, 'Dr. Mario'),
(19, 1, 'Pichu'),
(20, 1, 'Falco'),
(21, 1, 'Marth'),
(22, 1, 'Young Link'),
(23, 1, 'Ganondorf'),
(24, 1, 'Mewtwo'),
(25, 1, 'Roy'),
(26, 1, 'Mr. Game & Watch'),
(27, 1, 'Meta Knight'),
(28, 1, 'Pit'),
(29, 1, 'Zero Suit Samus'),
(30, 1, 'Wario'),
(31, 1, 'Snake'),
(32, 1, 'Ike'),
(33, 1, 'Squirtle'),
(34, 1, 'Ivysaur'),
(35, 1, 'Charizard'),
(36, 1, 'Diddy Kong'),
(37, 1, 'Lucas'),
(38, 1, 'Sonic'),
(39, 1, 'King Dedede'),
(40, 1, 'Olimar'),
(41, 1, 'Lucario'),
(42, 1, 'R.O.B.'),
(43, 1, 'Toon Link'),
(44, 1, 'Wolf'),
(45, 1, 'Villager'),
(46, 1, 'Mega Man'),
(47, 1, 'Wii Fit Trainer'),
(48, 1, 'Rosalina & Luma'),
(49, 1, 'Little Mac'),
(50, 1, 'Greninja'),
(51, 1, 'Mii Brawler'),
(52, 1, 'Mii Swordfighter'),
(53, 1, 'Mii Gunner'),
(54, 1, 'Palutena'),
(55, 1, 'Pac-Man'),
(56, 1, 'Robin'),
(57, 1, 'Shulk'),
(58, 1, 'Bowser Jr.'),
(59, 1, 'Dunk Hunt'),
(60, 1, 'Ryu'),
(61, 1, 'Cloud'),
(62, 1, 'Corrin'),
(63, 1, 'Bayonetta'),
(64, 1, 'Inkling'),
(65, 1, 'Ridley'),
(66, 1, 'Simon'),
(67, 1, 'King K. Rool'),
(68, 1, 'Isabelle'),
(69, 1, 'Incineroar'),
(70, 1, 'Piranha Plant'),
(71, 1, 'Joker'),
(72, 1, 'Hero'),
(73, 1, 'Banjo & Kazooie'),
(74, 1, 'Terry'),
(75, 1, 'Byleth'),
(76, 1, 'Min Min'),
(77, 1, 'Steve/Alex'),
(78, 1, 'Sephiroth'),
(79, 1, 'Pyra'),
(80, 1, 'Mythra'),
(81, 1, 'Kazuya'),
(82, 1, 'Sora');



INSERT INTO public.personaje2 (id, echo, nombre) VALUES
(1, 1, 'Mario'),
(2, 1, 'Donkey Kong'),
(3, 1, 'Link'),
(4, 1, 'Samus'),
(5, 1, 'Yoshi'),
(6, 1, 'Kirby'),
(7, 1, 'Fox'),
(8, 1, 'Pikachu'),
(9, 1, 'Luigi'),
(10, 1, 'Ness');


INSERT INTO public.posicion (id, nombre) VALUES
(1, 'Plataforma Principal');


INSERT INTO public.registro (id, idpersonajeemisor, idpersonajereceptor, idmovimiento, idescenario, idposicion, porcentajeko, rage, di) VALUES
(3, 35, 73, 16, 1, 1, 122, 0, 't'),
(1, 35, 63, 16, 1, 1, 105, 0, 't'),
(7, 35, 36, 16, 1, 1, 83, 150, 't'),
(8, 35, 36, 16, 1, 1, 101, 75, 't'),
(9, 35, 36, 16, 1, 1, 96, 100, 't'),
(10, 35, 36, 7, 1, 1, 108, 0, 't'),
(2, 35, 36, 16, 1, 1, 111, 0, 't'),
(4, 35, 66, 16, 1, 1, 122, 0, 't'),
(11, 35, 66, 7, 1, 1, 122, 0, 't'),
(12, 34, 66, 12, 1, 1, 127, 0, 't'),
(6, 35, 79, 16, 1, 1, 115, 0, 't'),
(5, 35, 74, 16, 1, 1, 125, 0, 't');


SELECT pg_catalog.setval('public.personaje2_id_seq', 1, false);


--
-- TOC entry 3209 (class 2606 OID 24582)
-- Name: escenario escenario_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.escenario
    ADD CONSTRAINT escenario_pkey PRIMARY KEY (id);


--
-- TOC entry 3211 (class 2606 OID 24605)
-- Name: movimiento movimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id);


--
-- TOC entry 2065 (class 826 OID 16392)
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON SEQUENCES TO neon_superuser WITH GRANT OPTION;


--
-- TOC entry 2064 (class 826 OID 16391)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON TABLES TO neon_superuser WITH GRANT OPTION;




