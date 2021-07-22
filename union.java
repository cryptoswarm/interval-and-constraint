public  Contrainte union(Intervalle intervalle ) {

                List<Intervalle> list = new ArrayList<>();

                Contrainte c = new Contrainte(list);

                


               if (intervalle!= null){

                    int l = 0;
                    int max = 0;

                    if (this.getDebut()==intervalle.debut && this.getFin() == intervalle.fin) {

                       list.add(this);
                      // c.addAll(0, list);
                       // c.add(0, this);
                    }


                    if (this.getDebut() < intervalle.getDebut() && this.getFin() > intervalle.getFin()) {

                        list.add(this);
                        c.addAll(0, list);
                    }




                    if (this.getDebut() < intervalle.debut && this.getFin() < intervalle.fin && intervalle.debut < this.getFin()) {

                        list.add(new Intervalle(this.getDebut(), intervalle.fin));
                        c.addAll(0, list);
                    }



                    if (this.getDebut() == intervalle.getDebut()) {
                        if (this.getFin() > intervalle.getFin()) {
                            list.add(new Intervalle(this.getDebut(), this.getFin()));
                        } else {
                           list.add(new Intervalle(this.getDebut(), intervalle.getFin()));
                        }

                        c.addAll(0, list);
                    }


                    if (this.getDebut() < intervalle.debut) {
                        l = this.getDebut();
                    } else {
                        l = intervalle.debut;
                    }

                    if (this.getFin() > intervalle.fin) {
                        max = this.getFin();
                    } else {
                        max = intervalle.fin;
                    }


                    list.add(new Intervalle(l, max));

                    c.addAll(0, list);

               }
               c = new Contrainte(list);

          return c;

      }