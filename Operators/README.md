# Operators

## Unary Plus Operator(+)
- operand must be primitive numeric type
- if the operand is a `byte`, `short` or `char`, it gets promoted to an int. Otherwise, using this operator has no effect.

```java
byte num1 = 9;
byte num2 = 3;
num1 = num2;
num1 = +num2; // compilation fails
```
- The compilation fails due to the following reason,
    - `num2` is of type byte. But, with the use of unary plus operator on num2 will promote its type to int. So +num2 is of type int.
    - Assign the int num2 to a byte num1 is not allowed. So compilartion fails
- fix
`num1 =(byte)+num2`;// compilation will be successfull

---

## Unary Minus Operator(-)
- Same behaviour as above
- Applyting the minus operator 2time, will result in the same positive number.
    - `num = -(-9);` -> // num will be assigned with 9

---

## Compound Arithmetic Assignment Operators

- Each of the five fundamental arithmetic operators(+, -, *,/ and %) has an associated `compound arithmetic assignment` operator.
- `operand1 op= oprand2`
- Two advantages associated with the use of compound arithmetic assignment operators.
1. `Performance`
    - Operand1 is evaluated only once
    - for instance in `num+=3.3`, the variable num is evaluated only once, in contrast in `num = (int)num+3.3`, the variable num is evaluated 2 times
2. `Automatic casting`
    - The result is automatically cast to the type of operand1 before assignment. This cast may result in either narrowing conversion of any identity conversion.
    - implicit casting is automatic
        - int -> float or double

---

## Increment and Decrement operators
