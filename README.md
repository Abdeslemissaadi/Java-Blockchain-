Java Blockchain Simulation – Proof of Work Project
🚀 Présentation du projet

Ce projet est une implémentation pédagogique d’une blockchain simplifiée en Java, permettant de comprendre les concepts fondamentaux des systèmes distribués et de la cryptographie appliquée.

Il simule une chaîne de blocs contenant des transactions, sécurisée par des fonctions de hachage SHA-256 et un mécanisme de Proof of Work (minage).

 Objectifs 

Ce projet permet de comprendre :

Le hachage cryptographique (SHA-256) SHA-256

Le fonctionnement d’une blockchain

La structure de données Merkle Tree

Le principe de Proof of Work (minage)

Le chaînage sécurisé des blocs via previousHash

La validation d’intégrité d’une chaîne de blocs

⚙️ Architecture

Le projet est composé de 4 classes :

📦 Block.java

Représente un bloc de la blockchain.

Contient :

index du bloc

transactions (data)

timestamp

hash du bloc

previousHash

nonce (minage)

Merkle Root

Utilise SHA-256 pour sécuriser les données et construire le hash du bloc.

⛓️ Blocks.java

Gère la blockchain entière.

Fonctions principales :

création du Genesis Block

ajout de nouveaux blocs

minage (Proof of Work)

validation de la chaîne

affichage des blocs

Chaque bloc est lié au précédent via previousHash.

⛏️ miner.java

Implémente le Proof of Work

🚀 main.java

Interface console du projet.

Permet :

création de la blockchain

ajout de blocs avec transactions

minage automatique

affichage de la chaîne

test de validité

modification de blocs

<img width="777" height="291" alt="image" src="https://github.com/user-attachments/assets/593f0571-c261-4fd2-8c37-5a6d99e43f38" />

<img width="850" height="446" alt="image" src="https://github.com/user-attachments/assets/147a7900-d8b6-424a-916b-0090d821ac55" />

<img width="815" height="496" alt="image" src="https://github.com/user-attachments/assets/e1d43617-b547-491b-8a21-3e95a3716b7b" />



🔐 Concepts utilisés

SHA-256 hashing

Merkle Tree (sécurisation des transactions)

Proof of Work (minage)

Chaînage via previousHash

Validation d’intégrité

⚙️ Technologies utilisées

☕ Java (JDK 8+)

🔐 MessageDigest (SHA-256)

📦 Collections (ArrayList)

⌨️ Programmation console (Scanner)
