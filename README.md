**Singleton Pattern** -  folosit pentru a crea o singura instanta a clasei EShop.

**Observer Pattern** - folosit in mod special in sellers/ , unde SellerManager ul este subiectul (contine o lista de observatori pe care poate sa ii adauge/stearga/notifice) , iar ConcreteSellerObserver este observatorul. Atunci cand SellerManagerul face o schimbare (adauga/sterge), notifica observatorul.

**Command Pattern** - Folosit in commands/ - clasa AddToCartCommand permite adaugarea produselor in cos, clasa RemoveFromCartCommand permite stergea produselor din cos. Pattern ul este folosit pentru a permite extinderea proiectului
