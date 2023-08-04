# TransferTech [Kontenliste]

## :page_with_curl: Konzeption:

Die App setzt sich aus verschiedenen Entwicklungsansätzen zusammen:
- *Gestaltung der Benutzeroberfläche und Anpassung des Layouts.*
* *Planung und Umsetzung des MVVM-Patterns.*
+ *Implementierung der Kernfunktionen und Integration des Retrofit-Services.*
- *Fehlerbehebung, Tests und Implementierung zusätzlicher Features.*

## Funktionalität und Hinweise:

Beim Starten der App wird automatisch ein API-Abruf durchgeführt, um fiktive Bankdaten und Umsätze abzurufen. Diese Informationen werden dann in Form einer Liste angezeigt. Zusätzlich ermöglicht es die App, bei Auswahl eines bestimmten Accounts in die Detail-Ansicht zu navigieren, in der die Umsätze und Transaktionen für das jeweilige Konto detailliert angezeigt werden.

## :rocket: Verwendete Frameworks:
* *Retrofit / REST-Client-Bibliothek*
- *Jetpack Navigation Component*
+ *Robolectric Framework*
* *JUnit 4 Framework*
- *Mockito Framework*

## :computer: Lieblings Codeausschnitt:

*Dieser Codeausschnitt dient dazu, den API-Request zu beobachten, der gemacht wurde, und anschließend die Account-ID aus der LiveData zu filtern. Dadurch werden die zugehörigen Umsätze einer Account-ID zugewiesen und am Ende als Liste angezeigt.*
```
 viewModel.turnoverAccRequest.observe(viewLifecycleOwner) { turnoverAccList ->
            val filterList = turnoverAccList.filter { turnoverAcc ->
                turnoverAcc.account_id.toString() == accID
            }
            turnoverAdapter.submitlist(filterList)
        }
```

















