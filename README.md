# Shopping Cart Application

Welcome to the Shopping Cart Application! This console-based program allows you to manage your shopping cart by adding, deleting, and listing items.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Commands](#commands)
- [Examples](#examples)

## Features

- Add items to your shopping cart.
- Delete items from your shopping cart.
- List the contents of your shopping cart.
- Close the shopping cart with the "stop" command.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your computer.

### Installation

1. Clone this repository or download the source code.
2. Compile the Java source code.

```shell
javac App.java ShoppingCart.java
```

3. Run the program.

```shell
java App
```

## Usage

1. Launch the program.
2. Enter commands to interact with your shopping cart.

## Commands

- `add <item1>, <item2>, ...` - Add items to your shopping cart (items have to be separated by a comma).
- `delete <position>` - Delete an item from your shopping cart by specifying its position on the list.
- `list` - List the contents of your shopping cart.
- `stop` - Close the shopping cart and exit the program.

## Examples

- Add items to the cart:

```shell
add apple, banana, orange
```

- Delete an item from the cart (replace `<position>` with the actual item position):

```shell
delete 2
```

- List the contents of the cart:

```shell
list
```

- Close the shopping cart and exit the program:

```shell
stop
```

---
