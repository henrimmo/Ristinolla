Aihe: Ristinolla. 

Toteutan graafista käyttöliittymää käyttävän kahden henkilön ristinollan.
Pelaajat ovat ristiä pelaava, jonka ruudut merkataan ristein ja nolla, jonka ruudut merkataan nollin.
Peliä pelataan 3x3 ruudukolla.
Pelaajat klikkaavat vuorotellen pelilaudan ruutuja saadakseen ne itselleen.
Pelin tavoitteena saada 3 omaa merkkiä samalle riville vaaka- tai pystysuoraan taikka vinoon ja estää vastustajaa tekemästä samaa.
Risti aloittaa pelin.

Käyttäjät: Ristiä pelaava pelaaja, nollaa pelaava pelaaja

Pelaajan toimonnot:

Pelin aloittaminen
Pelaaminen
Voittaminen
Uuden pelin aloitus
Pelin lopetus
Pistetilastojen katsominen
Tallentaminen
Lataaminen




Ohjelma alkaa kun kutsutaan käyttöliittymän run metodia, joka luo ikkunan ja kutsuu puolestaan luoKomponentit metodia.
Tämä luo ikkunaan 3x3 JButtonesita koostuvan ruudukon, menupalkin ja alas vuoronilmoittajan. Peli on valmis alkamaan.
Nappeja painellessa niihin ilmestyy vuorosta riippuen joko X tai 0. Jokaisen vuoron päätteeksi peli tarkistaa täyttyikö voittoehto. Mikäli ehto täytyy, ilmestyy näytölle ilmoitus jossa kysytään halutaanko aloittaa uusi peli tai lopettaa.
