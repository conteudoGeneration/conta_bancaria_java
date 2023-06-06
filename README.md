# Projeto Conta Bancária - POO - Java

<br />

<div align="center">
   <img src="https://i.imgur.com/IaD4lwg.png" title="source: imgur.com" width="25%"/>
</div>

<br /><br />

## Diagrama de Classes

```mermaid
classDiagram
class Conta {
  - numero : int
  - agencia : int
  - tipo : int
  - titular : String
  - saldo : float
  + int getNumero()
  + int getAgencia()
  + int getTipo()
  + String getTitular()
  + float getSaldo()
  + void setNumero(int numero)
  + void setAgencia(int agencia)
  + void setTipo(int tipo)
  + void setTitular(String titular)
  + void setSaldo(float saldo)
  + boolean sacar(float valor)
  + void depositar(float valor)
  + void visualizar()
}
class ContaCorrente {
  - limite : float
  + float getLimite()
  + void setLimite(float limite)
  + boolean sacar(float valor)
  + void visualizar()
}
class ContaPoupanca {
  - aniversario : int
  + int getAniversario()
  + void setAniversario(int aniversario)
  + void visualizar()
}
ContaCorrente --> Conta
ContaPoupanca --> Conta
```

<br /><br />

## Print da Tela

<div align="center">
   <img src="https://i.imgur.com/WtJBivM.png" title="source: imgur.com" />
</div>
