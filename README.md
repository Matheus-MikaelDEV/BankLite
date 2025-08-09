# 💸 BankLite

BankLite é um sistema bancário simples em linha de comando, desenvolvido em Java. Ele permite o cadastro de uma conta, visualização dos dados e realização de saques com validações básicas.

## 📌 Funcionalidades

- Cadastro de conta bancária
- Saques com validação:
  - Valor deve ser maior que zero
  - Valor não pode ultrapassar o limite de saque
  - Valor não pode ultrapassar o saldo da conta
- Exibição das informações da conta

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Pacotes e organização modular
- Tratamento de exceções (`try-catch`)
- Operações financeiras com `BigDecimal`

## 🛠️ Tecnologias utilizadas

- Java 17 ou superior
- IntelliJ IDEA / Eclipse / VS Code (ou outra IDE de sua preferência)

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/SeuUsuario/BankLite.git
```

2. Acesse a pasta do projeto:

```bash
cd BankLite
```

3. Compile e execute o programa:

Se estiver usando uma IDE:
- Basta rodar a classe `Main` dentro do pacote `application`.

Ou via terminal:

```bash
javac application/Main.java
java application.Main
```

## 📁 Estrutura de pacotes

```
src/
├── application/
│   └── Main.java
├── maneger/
│   └── Sistema.java
└── model/
    └── account/
        └── Conta.java
```

## 👤 Autor

**Matheus Mikael**

---

📌 *Projeto desenvolvido com fins educacionais para praticar os fundamentos de Java e os princípios da POO.*
