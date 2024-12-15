
![bannière TP](images/banniere.png)
ESIEE-IT - (BTS SIO SLAM) - 04/10/2024

---

### Table "Utilisateur"

utilisateur(id:int(3), login:varchar(20), mdp:varchar(20), nom: varchar(20), prenom:varchar(20), dateEmbauche:datetime, role: enum('ADMIN', 'EMPLOYE'))
- clé primaire: id
- clé étrangère: ___
- champs unique: login

### Table "Trajet"
trajet(code:varchar(20), tempsDepart:datetime, tempsArrivee:datetime, arretDepartId: int(3), arretArriveeId: int(3))
- clé primaire: code
- clé étrangère: 
    - arretDepartId référence à Arret.id,
    - arretArriveeId référence à Arret.id

### Table "Arret"

arret(id: int(3), nom: varchar(30)) 
- clé primaire: id
- clé étrangère: ___


### 1. Récupérer l'utilisateur qui a un login = ...
`SELECT * FROM Utilisateur WHERE login = '...';`
### 2. Lister les utilisateurs qui sont ADMIN
`SELECT * FROM Utilisateur WHERE role = 'ADMIN';`
### 3. Récupérer les trajets sur une période donnée
`SELECT * FROM Trajet WHERE tempsDepart >= '2024-01-01 00:00:00' AND tempsArrivee <= '2024-01-31 23:59:59';`
### 4. 
### - a. Ajouter un employé avec toutes les infos
`INSERT INTO Utilisateur (id, login, mdp, nom, prenom, dateEmbauche, role) VALUES (1, 'nouveauLogin', 'motDePasse', 'Nom', 'Prenom', '2024-10-15 09:00:00', 'EMPLOYE');`
### - b. Supprimer un employé avec un id ou login
`DELETE FROM Utilisateur  WHERE id = 1 OR login = '...';`
### 5. Modifier le temps d'arrivée d'un trajet avec son code
`UPDATE Trajet SET tempsArrivee = '2024-10-15 14:30:00' WHERE code = 'code';`