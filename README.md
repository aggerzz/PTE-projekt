# PTE-projekt
I uge 10-12 skal vi arbejde med vores PTE projekt hvor vi hjælper produktions-teknologerne med at løse deres eksamensopgaver. 

#Lav din egen fork

Tryk på fork oppe i højre hjørne af https://github.com/HEDMU-2016/PTE-projekt/

<img src="http://imgur.com/sYtVHaj.png">

Så skal du trykke på din egen profil som vist her

<img src="http://imgur.com/IDnwcKu.png">

Så vil github loade i et stykke tid, hvorefter du vil blive sendt til din egen fork af projektet, her skal du trykke "clone or download"

<img src="http://imgur.com/4K0ebyT.png">

Så kopiere du linket

<img src="http://imgur.com/0LdkeFY.png">

#Importer til eclipse.
Åben dit Eclipse... (har du ikke Eclipse så kan det hentes her: https://www.eclipse.org/downloads/ )

I dit Eclipse gå til Window -> Show View -> Other -> Marker "Git Repositories" og "Git Staging" og tryk ok.

<img src="http://imgur.com/M2MPPl8.png">      <img src="http://imgur.com/9bcgIfL.png">

Højreklik i dit "Git Repositories" vindue og tryk "Paste Repository Path or URL"

<img src="http://imgur.com/I3u6EqW.png">

Udfyld User og Password med dine loginoplysninger til GitHub, og sæt ✓ i "Store in Secure Store" 

<img src="http://imgur.com/brClyzI.png">

Når du har gjort alt det trykker du "Next"

Du vil så blive mødt med denne skærm hvor du også blot skal trykke "Next"

<img src="http://imgur.com/dTXTsd4.png">

Så vil du blive mødt af denne skærm, her skal du blot trykke "Finish"

<img src="http://imgur.com/dJE5bQj.png">

For at kunne arbejde på projektet skal du nu importere det til dine projects - dette gøres ved at højreklikke i dit Package Explorer og vælge "Import..." 

<img src="http://imgur.com/tfwNccG.png">

Herefter vil du blive mødt af følgende vindue:

<img src="http://imgur.com/ybtolhq.png">

Her skal du som vist vælge "Git -> Projects from Git" og trykke "Next"

Så bliver du mødt af denne skærm:

<img src="http://imgur.com/CfgVi0n.png">

Her vælger du "Existing local Repository" og trykker "Next", så kommer følgende skærm:

<img src="http://imgur.com/p96BGOS.png">

Så vælger du PTE-Projekt og trykker "Next".

<img src="http://imgur.com/lXweWFf.png">

Her vælger du "Import exsisting Eclipse projects" og trykker "Next"

Så bliver du mødt af denne skærm:

<img src="http://imgur.com/hvVw7GK.png">

Her kan du tilføje det til dit Working Set (hvis du benytter dig af det), tryk herefter på "Finish" og projektet er nu importeret.

For at du kan arbejde i projektet skal du nu højreklikke på det i din Package Explorer og vælge "Properties":

<img src="http://imgur.com/3dYdfKp.png">

Så vælger du "Java Build Path" ude til venste og "Libraries" øverst.

<img src="http://imgur.com/uAIWBGB.png">

Her trykker du på "Add Library", og får denne pop-up:

<img src="http://imgur.com/87gAARr.png">

Vælg "JavaFX SDK" og tryk "Finish"

Så vil du blive mødt med dette vindue:

<img src="http://imgur.com/dhlsuvo.png">

Her tykker du "Apply" og "OK"

Hvis dit Eclipse giver dig en masse fejl, så prøv lige at genstarte det før du spørger om hjælp.

#Få din ændring gennemført

For at få din ændring gennemført skal du sørge for at du fetcher fra HEDMU repositoryet, dette gøres sådan her:

Gå ind i eclipse, "Git Repositories" -> "PTE-Projekt", højreklik på remotes og vælg "Create Remote..."

<img src="http://imgur.com/dJuvc6v.png">

Så får du en pop-up, her skal du som navn skrive "HEDMU" og vælge "Configure fetch" og trykke OK

<img src="http://imgur.com/WxaLF5m.png">

Ved den næste skærm skal du trykke "Change", så får du endnu et pop-up

<img src="http://imgur.com/csmaJaK.png">

Her skal du skrive "https://github.com/HEDMU-2016/PTE-projekt.git" I URL, hvis du så har fuldt instrukserne indtil nu burde den selv flyde resten ud så du kan trykke på "Finish"

<img src="http://imgur.com/114QTFx.png">

Så trykker du på Save:

<img src="http://imgur.com/aw4fG0V.png">

Nu har du to remotes:

<img src="http://imgur.com/6hdnHjt.png">

For så at få de nyeste ændringer fra vores fælles git skal du først fetche fra "HEDMU"

<img src="http://imgur.com/gIizT0p.png">

Herefter får du et popup der minder om dette, her skal du bare trykke "OK":

<img src="http://imgur.com/etaUVaP.png">

Så skal du pulle, ved at højreklikke på projektet og gå til "Team" -> "Pull"

<img src="http://imgur.com/MoVfxwH.png">

Så får du endnu et vindue hvor du kan se hvilke ændringer der er kommet

<img src="http://imgur.com/AZUBMtI.png">



Når du skal pushe skal du gøre det på følgende måde:

Gem dine ændringer, gå til Git Staging og læg de filer du vil uploade ned i staged files, skriv din commit besked og tryk på Commit

<img src="http://imgur.com/F2tTsMv.png">
<img src="http://imgur.com/46q8VSy.png">

Herefter skal du ud til dine remotes og højreklike på origin og trykke push

<img src="http://imgur.com/Iotf94L.png">

Så får du en pop-up der ligner denne, her skal du bare trykke "OK"

<img src="http://imgur.com/lndUIkC.png">

Nu har du pushet din ændring til din fork!


Når du nu har lavet en ændring og pushet den til din fork skal du oprette en pull request for at få ændringen ud til alle andre, dette gøres på følgende måde:

Du går ind på din egen fork af projektet og trykker på "New pull request"

<img src="http://imgur.com/v5spJ7t.png">

Nu bliver du præsenteret for dine ændringer, hvis dette ser fint ud trykker du på "Create pull request"

<img src="http://imgur.com/EvLGw98.png">

Så skal du beskrive dine ændringer så administratoren kan gennemskue hvad du har lavet

<img src="http://imgur.com/CaoqH0E.png">

Nu kan du se status på din pull request, her vil administratoren kunne tilføje kommentare til request hvis der er noget han/hun ikke kan lide

<img src="http://imgur.com/y4ZcVII.png">

Når din commit er godkendt vil dette vindue se sådan her ud:

<img src="http://imgur.com/firNRql.png">


