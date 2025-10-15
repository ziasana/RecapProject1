# 🧠 Policy & Signaturen (Design vor Code)
Mit dieser Java-Konsolenanwendung können Benutzer die Stärke eines Passworts überprüfen oder ein sicheres Passwort mit einer bestimmten Länge generieren. Sie verwendet eine benutzerdefinierte Passwortvalidierungslogik und einen sicheren Zufallspasswortgenerator. Die App basiert auf Maven und ermöglicht so eine einfache Abhängigkeitsverwaltung und Projekteinrichtung.

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
| Aa3$567&8   | true      | alle Kriterien                                          |



### Build/Run/Tests:

lokal: mvn clean verify