PGDMP      9                |            sismed    17.2    17.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16676    sismed    DATABASE     }   CREATE DATABASE sismed WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE sismed;
                     postgres    false                        3079    16702    pgcrypto 	   EXTENSION     <   CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;
    DROP EXTENSION pgcrypto;
                        false            �           0    0    EXTENSION pgcrypto    COMMENT     <   COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';
                             false    2            �            1259    16933    consulta    TABLE     �   CREATE TABLE public.consulta (
    id uuid NOT NULL,
    id_medico uuid NOT NULL,
    id_paciente uuid NOT NULL,
    data_consulta date NOT NULL,
    status character varying(255)
);
    DROP TABLE public.consulta;
       public         heap r       postgres    false            �            1259    16813    medico    TABLE     �   CREATE TABLE public.medico (
    id uuid NOT NULL,
    nome character varying(255) NOT NULL,
    especialidade character varying(255) NOT NULL,
    crm character varying(255) NOT NULL,
    email character varying(255) NOT NULL
);
    DROP TABLE public.medico;
       public         heap r       postgres    false            �            1259    16844    paciente    TABLE     �   CREATE TABLE public.paciente (
    id uuid NOT NULL,
    nome character varying(255) NOT NULL,
    cpf character varying(255) NOT NULL,
    data_nascimento date NOT NULL,
    contato character varying(255),
    email character varying(255)
);
    DROP TABLE public.paciente;
       public         heap r       postgres    false            �          0    16933    consulta 
   TABLE DATA           U   COPY public.consulta (id, id_medico, id_paciente, data_consulta, status) FROM stdin;
    public               postgres    false    220   z       �          0    16813    medico 
   TABLE DATA           E   COPY public.medico (id, nome, especialidade, crm, email) FROM stdin;
    public               postgres    false    218   �       �          0    16844    paciente 
   TABLE DATA           R   COPY public.paciente (id, nome, cpf, data_nascimento, contato, email) FROM stdin;
    public               postgres    false    219   �       X           2606    16937    consulta consulta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_pkey;
       public                 postgres    false    220            N           2606    16875    medico medico_crm_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_crm_key UNIQUE (crm);
 ?   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_crm_key;
       public                 postgres    false    218            P           2606    16823    medico medico_email_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_email_key UNIQUE (email);
 A   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_email_key;
       public                 postgres    false    218            R           2606    16819    medico medico_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_pkey;
       public                 postgres    false    218            T           2606    16877    paciente paciente_cpf_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_cpf_key UNIQUE (cpf);
 C   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_cpf_key;
       public                 postgres    false    219            V           2606    16850    paciente paciente_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public                 postgres    false    219            Y           2606    16938     consulta consulta_id_medico_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_medico_fkey FOREIGN KEY (id_medico) REFERENCES public.medico(id) ON DELETE RESTRICT;
 J   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_id_medico_fkey;
       public               postgres    false    4690    220    218            Z           2606    16943 "   consulta consulta_id_paciente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.paciente(id) ON DELETE RESTRICT;
 L   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_id_paciente_fkey;
       public               postgres    false    4694    219    220            �      x������ � �      �      x������ � �      �      x������ � �     