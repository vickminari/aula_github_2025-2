# Sistema Bancário - Engenharia de Software II

## 📋 Descrição do Projeto

Sistema bancário simples desenvolvido em Java que simula operações básicas de um banco, incluindo gerenciamento de contas, clientes e transações financeiras.

## 🎯 Funcionalidades Desenvolvidas

### 1. Gerenciamento de Contas
- **Criar Conta**: Cadastro de novas contas bancárias com validação de duplicidade
- **Acessar Conta**: Consulta de informações de contas existentes
- **Validações implementadas**:
  - Não permite contas com mesmo número e agência
  - Não permite contas com mesmo CPF
  - Validação de dados nulos

### 2. Gerenciamento de Clientes
- **Listar Clientes**: Exibe todos os clientes cadastrados no banco
- **Buscar por CPF**: Localiza cliente através do CPF
- **Buscar por Nome**: Localiza conta através do nome do titular
- **Informações armazenadas**: Nome, CPF e Endereço

### 3. Operações Bancárias
- **Saque**: Retirada de valores com verificação de saldo disponível
- **Depósito**: Adição de valores à conta
- **Transferência**: Transferência de valores entre contas
- **Extrato**: Visualização do histórico de transações

## 🏗️ Estrutura do Sistema

### Classes Principais

#### `Cliente`
Representa o titular da conta bancária.
- **Atributos**: nome, cpf, endereco
- **Métodos**: getters e setters para todos os atributos

#### `Conta`
Representa uma conta bancária com composição com Cliente.
- **Atributos**: 
  - numeroConta
  - agencia
  - titular (Cliente)
  - saldo
  - transacoes (List<Object>)
- **Métodos**:
  - `saque(double valor)`: Realiza saque se houver saldo
  - `depositar(double valor)`: Adiciona valor ao saldo
  - `transferir(Conta destino, double valor)`: Transfere valor para outra conta
  - `exibirExtrato()`: Mostra histórico de transações

#### `Banco`
Gerencia todas as contas do sistema.
- **Atributos**: 
  - contas (ArrayList<Conta>)
- **Métodos**:
  - `adicionarConta(Conta conta)`: Adiciona conta com validações
  - `removerConta(Conta conta)`: Remove conta do banco
  - `getContaPorCPF(String cpf)`: Busca conta por CPF
  - `getContaPorNumeroAndAgencia(String numero, String agencia)`: Busca conta por número e agência
  - `getClientePorNome(String nome)`: Busca cliente por nome

#### `Menu`
Responsável pela interface do usuário e interação com o sistema.
- Gerencia a navegação entre menus
- Processa entrada de dados do usuário
- Executa operações bancárias

#### `Main`
Ponto de entrada da aplicação, inicializa o sistema.

## 🔄 Como o Sistema Funciona

### Fluxo de Execução

1. **Inicialização**: O sistema cria uma instância do Banco e exibe o menu principal
2. **Menu Principal**: Oferece três opções:
   - Conta
   - Cliente
   - Operações

3. **Fluxo de Conta**:
   ```
   Conta → Criar Conta ou Acessar Conta
   ```
   - Ao criar: solicita dados do cliente e da conta
   - Ao acessar: solicita número e agência para buscar

4. **Fluxo de Cliente**:
   ```
   Cliente → Listar | Buscar por CPF | Buscar por Nome
   ```

5. **Fluxo de Operações**:
   ```
   Operações → Saque | Depósito | Transferência | Extrato
   ```
   - Cada operação solicita identificação da conta (número + agência)
   - Valida se a conta existe antes de executar a operação

### Conceitos de POO Aplicados

- **Composição**: Conta possui Cliente (1:1)
- **Encapsulamento**: Atributos privados com getters/setters controlados
- **Validação**: Regras de negócio aplicadas nas operações
- **Genericidade**: Lista de transações usa `List<Object>` para flexibilidade

### Sistema de Transações

O histórico de transações é armazenado como `List<Object>`, permitindo dois modelos:
- **Strings simples**: Ex: "Saque: -500.00"
- **Objetos Transacao**: Para implementação futura de classe estruturada

## 🚀 Como Executar

1. Compile todos os arquivos Java:
   ```bash
   javac *.java
   ```

2. Execute a classe Main:
   ```bash
   java Main
   ```

3. Navegue pelos menus digitando o número da opção desejada

## 📝 Exemplo de Uso

```
Menu Principal

1 - Conta
2 - Cliente
3 - Operacoes
Informe a opcao desejada: 1

Opções de Conta:
1 - Criar conta
2 - Acessar conta
1

Digite o nome do titular: João Silva
Digite o CPF do titular: 123.456.789-00
Digite o endereço do titular: Rua A, 123
Digite o número da conta: 12345
Digite a agência: 0001
Conta criada com sucesso!
```

## 👥 Atividades Desenvolvidas

- Criação da estrutura básica de classes (Cliente, Conta, Banco)
- Implementação de composição entre Conta e Cliente
- Desenvolvimento de operações bancárias (saque, depósito, transferência)
- Sistema de validação para evitar duplicidade de contas
- Interface de menu interativa
- Sistema de histórico de transações
- Métodos de busca e consulta

## 🔒 Validações Implementadas

- Não permite criar contas com número/agência duplicados
- Não permite criar contas com CPF duplicado
- Valida saldo suficiente para saque e transferência
- Valida valores positivos para depósito
- Valida existência de contas antes de realizar operações

## 📚 Tecnologias

- Java
- ArrayList para armazenamento de dados
- Scanner para entrada de dados do usuário

---

**Disciplina**: Engenharia de Software II  
**Ano**: 2025
