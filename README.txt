Nom : REZALA, Prénom : Ayoub, NumEtu : 22309776 | Nom : IDRES, Prénom : Anis, NumEtu : 22212192

Toutes les 8 sections ont été faites (:-). 


Pour chaque package, il  existe au moins un fichier de Demo :
(!!!) Les Demos à prendre en compte sont celles se trouvant dans constraints et solvers car ce sont les versions finales de contraintes et de tri
    *Pour le package schedules.activities, le chemin est schedules/activities/Demo.java
    **Pour le package schedules.basicconstraints, le chemin est schedules/basicconstraints/Demo.java
    ***Pour le package schedules.basictopologicalsort, le chemin est schedules/basictopologicalsort/Demo.java
    ****Pour le package schedules.factoredconstraints, le chemin est schedules/factoredconstraints/Demo.java
    *****Pour le package schedules.factoredtopologicalsort, le chemin est schedules/factoredtopologicalsort/Demo.java
    ******Pour le package schedules.constraints, le chemin est schedules/constraints/Demo.java
    *******Pour le package schedules.solvers, les chemins sont schedules/solvers/VerifierDemo.java, schedules/solvers/RandomSchedulerDemo.java
1- Compilation et exécution des packages
    1.1 Package activities
    *Compilation et exécution de la classe Demo du package activities
    javac -d ../build/ schedules/activities/Demo.java
    java -cp ../build/ schedules.activities.Demo

    **Compilation et exécution de la classe Test du package activities
    javac -d ../build -cp ../lib/schedulestests.jar schedules/activities/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.activities.Test
    
    1.2 Package basicconstraints
    *Compilation et exécution de la classe Demo du package basicconstraints
    javac -d ../build/ schedules/basicconstraints/Demo.java
    java -cp ../build/ schedules.basicconstraints.Demo

    **Compilation et exécution de la classe Test du package basicconstraints
    javac -d ../build -cp ../lib/schedulestests.jar schedules/basicconstraints/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.basicconstraints.Test

    1.3 Package basictopologicalsort
    *Compilation et exécution de la classe Demo du package basictopologicalsort
    javac -d ../build/ schedules/basictopologicalsort/Demo.java
    java -cp ../build/ schedules.basictopologicalsort.Demo

    **Compilation et exécution de la classe Test du package basictopologicalsort
    javac -d ../build -cp ../lib/schedulestests.jar schedules/basictopologicalsort/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.basictopologicalsort.Test
    
    1.4 Package factoredconstraints
    *Compilation et exécution de la classe Demo du package factoredconstraints
    javac -d ../build/ schedules/factoredconstraints/Demo.java
    java -cp ../build/ schedules.factoredconstraints.Demo

    **Compilation et exécution de la classe Test du package factoredconstraints
    javac -d ../build -cp ../lib/schedulestests.jar schedules/factoredconstraints/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.factoredconstraints.Test

    1.5 Package factoredtopologicalsort
    *Compilation et exécution de la classe Demo du package factoredtopologicalsort
    javac -d ../build/ schedules/factoredtopologicalsort/Demo.java
    java -cp ../build/ schedules.factoredtopologicalsort.Demo

    **Compilation et exécution de la classe Test du package factoredtopologicalsort
    javac -d ../build -cp ../lib/schedulestests.jar schedules/factoredtopologicalsort/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.factoredtopologicalsort.Test

    1.6 Package constraints
    *Compilation et exécution de la classe Demo du package constraints
    javac -d ../build/ schedules/constraints/Demo.java
    java -cp ../build/ schedules.constraints.Demo

    **Compilation et exécution de la classe Test du package constraints
    javac -d ../build -cp ../lib/schedulestests.jar schedules/constraints/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.constraints.Test

    1.7 Package solvers
    *Compilation et exécution de la classe Demo du package solvers
    Nous avons deux démos : un sur le Verifier et l'autre, plus global sur le RandomScheduler
    javac -d ../build/ schedules/solvers/VerifierDemo.java
    javac -d ../build/ schedules/solvers/RandomScheduler.java
    java -cp ../build/ schedules.solvers.VerifierDemo
    java -cp ../build/ schedules.solvers.RandomScheduler
    
    **Compilation et exécution de la classe Test du package solvers
    javac -d ../build -cp ../lib/schedulestests.jar schedules/solvers/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.solvers.Test
    A l'exécution des tests, il faut entrer une graine en argument
    
    1.8 Package constraintstests
    *Compilation et exécution de la classe Test du package constraintstests
    javac -d ../build/ schedules/constraintstests/Test.java
    java -cp ../build/ schedules.constraintstests.Test

    **Compilation et exécution de la classe Test du package solvers
    javac -d ../build -cp ../lib/schedulestests.jar schedules/solvers/Test.java
    java -cp ../build:../lib/schedulestests.jar schedules.solvers.Test
2 - Compléments (Exercices optionnels)
2.1. (Premier rendu)On a fait le tri topologique linéaire, (optionnel) et comparé les vitesses d'exécution des fonctions bruteForceSort() et linearTimeSort() en utilisant java.util.currentTimeMillis()
2.2. (Second rendu) Pour le second rendu, nous avons fait les classes optionnelles NegationConstraint, DisjunctionConstraint également. Nous avons aussi réaliser les packages de tests correspondant aux précdentes classes.

3. Remarques sur les différentes classes

*Dans la classe schedules.solvers.RandomScheduler, le test concernant la méthode generateschedule() ne passe pas pourtant la méthode dans la démo fonctionne correctement.

**Pour le package solvers, dans la Demo, on a fait un exemple qui génère de nombreux emplois du temps possibles pour un ensemble donné d'activités.

***Étant donné que c'est le package constraints la dernière version de constraints, de vrais exemples de démos y sont plus développés et détaillés que dans factoredconstraints.
De même pour le package solvers (et factoredtopologicalsort) :) .

****Pour les tests, nous avons créé la classe schedules.constraintstests et les classes de tests NegationConstraintTester() et DisjunctionConstraintTester(). Ces classes vérifient pour chacune des contraintes, NegationConstraint et DisjunctionConstraint si elles implémentent l'interface Constraint(testImplements), si elles renvoient les bonnes activités(testGetActivities) et enfin si le isSatisfied est bon (testIsSatisfied). 


