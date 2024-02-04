CREATE DATABASE GestionTarjetas;
\c gestiontarjetas;

CREATE TABLE IF NOT EXISTS public.tarjetas
(
    numero_tarjeta character varying COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    documento_identidad character varying(10) COLLATE pg_catalog."default",
    pin character varying(4) COLLATE pg_catalog."default",
    limite_credito integer,
    fecha_caducidad date,
    CONSTRAINT tarjetas_pkey PRIMARY KEY (numero_tarjeta)
);

CREATE SEQUENCE movimientos_id_seq;

CREATE TABLE IF NOT EXISTS public.movimientos
(
    id serial PRIMARY KEY,
    numero_tarjeta character varying(16) COLLATE pg_catalog."default",
    concepto character varying COLLATE pg_catalog."default",
    cantidad double precision,
    fecha date,
    CONSTRAINT movimientos_numero_tarjeta_fkey FOREIGN KEY (numero_tarjeta)
        REFERENCES public.tarjetas (numero_tarjeta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

INSERT INTO tarjetas (VALUES
                          ('4923775926942205', 'ENRIQUE ORTEGA LLAMAS', '87610704R', '1995', '1000', '2028/05/20'),
                          ('4602258022120214', 'FRANCISCO JAVIER GIMENEZ BERMEJO', '29879083J', '1995','1500', '2028/05/20'),
                          ('4816014345550369', 'CLAUDIO PASCUAL MARTINEZ', '46935845K', '1969','1000', '2028/05/20'),
                          ('4934617702253307', 'LEONOR APARICIO ALBA', '04317646V', '1995','3000', '2028/05/20'),
                          ('4053828659168027', 'SANDRA ROMERO SEVILLA', '58953601R', '1976','500', '2028/05/20')
);

INSERT INTO movimientos (VALUES
                          (DEFAULT,'4923775926942205', 'Compra de alimentos frescos y productos de despensa en el supermercado local para abastecer la despensa del hogar.', '50.00', '2028/05/20'),
                          (DEFAULT,'4923775926942205', 'Servicio de transporte en taxi desde el aeropuerto hasta el hotel Palace en la ciudad de Granada.', '100.00','2028/05/20'),

                          (DEFAULT,'4602258022120214', 'Suscripción mensual a servicios de streaming de música y video para disfrutar de un amplio catálogo de contenidos bajo demanda.', '500.00', '2028/05/20'),

                          (DEFAULT,'4816014345550369', 'Compra de ropa de temporada, incluyendo pantalones, camisetas y zapatos, en el Nevada.', '50.00','2028/05/20'),
                          (DEFAULT,'4816014345550369', 'Pago de alquiler mensual del apartamento correspondiente al mes de mayo.', '50.00', '2028/05/20'),
                          (DEFAULT,'4816014345550369', 'Recarga de saldo telefónico para el número 666666666 con el fin de mantener la comunicación y acceder a servicios móviles.', '300.00', '2028/05/20'),

                          (DEFAULT,'4934617702253307', 'Compra de boletos de cine para dos personas en el cine Kinepolis para disfrutar de una película de estreno en pantalla grande.', '1000.00', '2028/05/20'),

                          (DEFAULT,'4053828659168027', 'Pedido de comida a domicilio de una selección de platos principales, entrantes y postres del restaurante BrguerKing para disfrutar de una cena especial en casa.', '50.00', '2028/05/20')
);