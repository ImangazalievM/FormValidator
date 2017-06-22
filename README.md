# FormValidator
Библиотека для проверки полей ввода на корректность введенных данных 

## Подключение библиотеки

```gradle
compile 'imangazaliev:formvalidator:1.0.1'
```

## Пример использования:

Создаем форму:

```java
FormValidator validator = new FormValidator();
```
Инициализируем поле ввода:

```java
EditText loginField = (EditText) findViewById(R.id.loginField);
```

Создаем валидатор для поля:

```java
FieldValidator loginFieldValidator = new FieldValidator(loginField);
loginFieldValidator.addPattern(new ValidatePattern(".+", "Поле не может быть пустым"));
loginFieldValidator.addPattern(new ValidatePattern("[A-Za-z]{5,10}", "Можно использовать только латиницу (5-10)"));
```
Добавляем поле в форму

```java
validator.addField(loginFieldValidator);
```

Проверяем:

```java
boolean isValid = validator.validate();
```

Результат:

<img src="https://github.com/ImangazalievM/FormValidator/blob/master/screenshots/1.png" width="33%">

## Используем TextInputLayout

Также библиотека может работать с TextInputLayout:

```java
EditText loginField = (EditText) findViewById(R.id.loginField);
TextInputLayout loginInputLayout = (TextInputLayout) findViewById(R.id.loginInputLayout);
```
Создаем валидатор:

```java
FieldValidator loginFieldValidator = new FieldValidator(mLoginField, mLoginInputLayout);
...
```
Проверяем:

```java
boolean isValid = validator.validate();
```

Результат:

<img src="https://github.com/ImangazalievM/FormValidator/blob/master/screenshots/2.png" width="33%">

## Лицензия

The MIT License

Copyright (c) 2016 Mahach Imangazaliev 

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
