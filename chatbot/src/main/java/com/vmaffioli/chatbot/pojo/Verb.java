package com.vmaffioli.chatbot.pojo;

import java.util.Arrays;

/**
 * pojo class for verbs
 * @author vmm
 *
 */
public class Verb {


	private String verb;
	private String type;
	private PersonalPronouns presente;
	private PersonalPronouns preterito_imperfeito;
	private PersonalPronouns preterito_perfeito;
	private PersonalPronouns preterito_mais_que_perfeito;
	private PersonalPronouns futuro_do_presente;
	private PersonalPronouns condicional_futuro_do_preterito;
	private String[] TYPES = {"indicativo","conjuntivo_subjuntivo","imperativo","infinito_pessoal"};

	public Verb() {

	}

	public PersonalPronouns getPresente() {
		return presente;
	}

	public void setPresente(PersonalPronouns presente) {
		this.presente = presente;
	}

	public PersonalPronouns getPreterito_imperfeito() {
		return preterito_imperfeito;
	}

	public void setPreterito_imperfeito(PersonalPronouns preterito_imperfeito) {
		this.preterito_imperfeito = preterito_imperfeito;
	}

	public PersonalPronouns getPreterito_perfeito() {
		return preterito_perfeito;
	}

	public void setPreterito_perfeito(PersonalPronouns preterito_perfeito) {
		this.preterito_perfeito = preterito_perfeito;
	}

	public PersonalPronouns getPreterito_mais_que_perfeito() {
		return preterito_mais_que_perfeito;
	}

	public void setPreterito_mais_que_perfeito(PersonalPronouns preterito_mais_que_perfeito) {
		this.preterito_mais_que_perfeito = preterito_mais_que_perfeito;
	}

	public PersonalPronouns getFuturo_do_presente() {
		return futuro_do_presente;
	}

	public void setFuturo_do_presente(PersonalPronouns futuro_do_presente) {
		this.futuro_do_presente = futuro_do_presente;
	}

	public PersonalPronouns getCondicional_futuro_do_preterito() {
		return condicional_futuro_do_preterito;
	}

	public void setCondicional_futuro_do_preterito(PersonalPronouns condicional_futuro_do_preterito) {
		this.condicional_futuro_do_preterito = condicional_futuro_do_preterito;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getTYPES() {
		return TYPES;
	}
	
	@Override
	public String toString() {
		return "Verb [verb=" + verb + ", type=" + type + ", presente=" + presente.toString() + ", preterito_imperfeito="
				+ preterito_imperfeito.toString() + ", preterito_perfeito=" + preterito_perfeito.toString() + ", preterito_mais_que_perfeito="
				+ preterito_mais_que_perfeito.toString() + ", futuro_do_presente=" + futuro_do_presente.toString()
				+ ", condicional_futuro_do_preterito=" + condicional_futuro_do_preterito.toString() + "]";
	}


}
