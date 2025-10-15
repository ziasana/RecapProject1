# 🧠 Policy & Signaturen (Design vor Code)

## Passwort-Policy
### Muss-Kriterien:

- mindestens 8 Zeichen,
- mindestens zwei Ziffer (0–9), 
- Groß- und Kleinbuchstaben (beides muss vorkommen), 
- nicht in einer Liste häufiger/schwacher Passwörter,
- mindestens zwei Sonderzeichen #$%&?@(),
- Keine Leerzeichen


| Passwort    | Erwartung | Grund                                                   |
|-------------|-----------|---------------------------------------------------------|
| Abc1def     | false     | Sonderzeichen fehlt, Ziffer fehlt, mindestens 8 Zeichen |
| 22a H2%$2nh | false     | Leerzeichen,                                            |
| ab1(8&gj    | false     | Großbuchstabe fehlt                                     |       
| Aa3$567&8   | true      | alle Kriterien                                                    |
