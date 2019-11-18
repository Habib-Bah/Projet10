
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Listerappel_QNAME = new QName("http://wsService.ws.oc.com/", "listerappel");
    private final static QName _ProlongerpretResponse_QNAME = new QName("http://wsService.ws.oc.com/", "prolongerpretResponse");
    private final static QName _AjouterLivre_QNAME = new QName("http://wsService.ws.oc.com/", "ajouterLivre");
    private final static QName _InscriptionResponse_QNAME = new QName("http://wsService.ws.oc.com/", "inscriptionResponse");
    private final static QName _ListPretResponse_QNAME = new QName("http://wsService.ws.oc.com/", "ListPretResponse");
    private final static QName _Rappel_QNAME = new QName("http://wsService.ws.oc.com/", "rappel");
    private final static QName _SupprimerLivre_QNAME = new QName("http://wsService.ws.oc.com/", "supprimerLivre");
    private final static QName _ConnexionEquipe_QNAME = new QName("http://wsService.ws.oc.com/", "connexionEquipe");
    private final static QName _EnvoyerRappelResponse_QNAME = new QName("http://wsService.ws.oc.com/", "envoyerRappelResponse");
    private final static QName _USerReservation_QNAME = new QName("http://wsService.ws.oc.com/", "USerReservation");
    private final static QName _Connexion_QNAME = new QName("http://wsService.ws.oc.com/", "connexion");
    private final static QName _SupprimerRappel_QNAME = new QName("http://wsService.ws.oc.com/", "SupprimerRappel");
    private final static QName _Prolongation_QNAME = new QName("http://wsService.ws.oc.com/", "prolongation");
    private final static QName _Reservations_QNAME = new QName("http://wsService.ws.oc.com/", "reservations");
    private final static QName _ReserverResponse_QNAME = new QName("http://wsService.ws.oc.com/", "reserverResponse");
    private final static QName _TrouverlivreResponse_QNAME = new QName("http://wsService.ws.oc.com/", "trouverlivreResponse");
    private final static QName _SupprimerprolongationResponse_QNAME = new QName("http://wsService.ws.oc.com/", "SupprimerprolongationResponse");
    private final static QName _ListedeslivresResponse_QNAME = new QName("http://wsService.ws.oc.com/", "ListedeslivresResponse");
    private final static QName _ListeprolongationsResponse_QNAME = new QName("http://wsService.ws.oc.com/", "listeprolongationsResponse");
    private final static QName _Trouverlivre_QNAME = new QName("http://wsService.ws.oc.com/", "trouverlivre");
    private final static QName _IOException_QNAME = new QName("http://wsService.ws.oc.com/", "IOException");
    private final static QName _ReserverEnAvance_QNAME = new QName("http://wsService.ws.oc.com/", "reserverEnAvance");
    private final static QName _SupprimerLivreResponse_QNAME = new QName("http://wsService.ws.oc.com/", "supprimerLivreResponse");
    private final static QName _Utilisateur_QNAME = new QName("http://wsService.ws.oc.com/", "utilisateur");
    private final static QName _ReserverEnAvanceResponse_QNAME = new QName("http://wsService.ws.oc.com/", "reserverEnAvanceResponse");
    private final static QName _Retour_QNAME = new QName("http://wsService.ws.oc.com/", "Retour");
    private final static QName _ListAttente_QNAME = new QName("http://wsService.ws.oc.com/", "ListAttente");
    private final static QName _Inscription_QNAME = new QName("http://wsService.ws.oc.com/", "inscription");
    private final static QName _Reservation_QNAME = new QName("http://wsService.ws.oc.com/", "reservation");
    private final static QName _Listeprolongations_QNAME = new QName("http://wsService.ws.oc.com/", "listeprolongations");
    private final static QName _SupprimerReservations_QNAME = new QName("http://wsService.ws.oc.com/", "SupprimerReservations");
    private final static QName _ListPret_QNAME = new QName("http://wsService.ws.oc.com/", "ListPret");
    private final static QName _RetourResponse_QNAME = new QName("http://wsService.ws.oc.com/", "RetourResponse");
    private final static QName _EnvoyerRappel_QNAME = new QName("http://wsService.ws.oc.com/", "envoyerRappel");
    private final static QName _SupprimerRappelResponse_QNAME = new QName("http://wsService.ws.oc.com/", "SupprimerRappelResponse");
    private final static QName _USerReservationResponse_QNAME = new QName("http://wsService.ws.oc.com/", "USerReservationResponse");
    private final static QName _SupprimerReservationsResponse_QNAME = new QName("http://wsService.ws.oc.com/", "SupprimerReservationsResponse");
    private final static QName _Listedeslivres_QNAME = new QName("http://wsService.ws.oc.com/", "Listedeslivres");
    private final static QName _ConnexionEquipeResponse_QNAME = new QName("http://wsService.ws.oc.com/", "connexionEquipeResponse");
    private final static QName _ListerappelResponse_QNAME = new QName("http://wsService.ws.oc.com/", "listerappelResponse");
    private final static QName _Prolongerpret_QNAME = new QName("http://wsService.ws.oc.com/", "prolongerpret");
    private final static QName _ConnexionResponse_QNAME = new QName("http://wsService.ws.oc.com/", "connexionResponse");
    private final static QName _Supprimerprolongation_QNAME = new QName("http://wsService.ws.oc.com/", "Supprimerprolongation");
    private final static QName _ListUser_QNAME = new QName("http://wsService.ws.oc.com/", "listUser");
    private final static QName _AjouterLivreResponse_QNAME = new QName("http://wsService.ws.oc.com/", "ajouterLivreResponse");
    private final static QName _ProlongationsResponse_QNAME = new QName("http://wsService.ws.oc.com/", "prolongationsResponse");
    private final static QName _Prolongations_QNAME = new QName("http://wsService.ws.oc.com/", "prolongations");
    private final static QName _ListAttenteResponse_QNAME = new QName("http://wsService.ws.oc.com/", "ListAttenteResponse");
    private final static QName _ListUserResponse_QNAME = new QName("http://wsService.ws.oc.com/", "listUserResponse");
    private final static QName _Livre_QNAME = new QName("http://wsService.ws.oc.com/", "livre");
    private final static QName _Reserver_QNAME = new QName("http://wsService.ws.oc.com/", "reserver");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SupprimerReservations }
     * 
     */
    public SupprimerReservations createSupprimerReservations() {
        return new SupprimerReservations();
    }

    /**
     * Create an instance of {@link ListPret }
     * 
     */
    public ListPret createListPret() {
        return new ListPret();
    }

    /**
     * Create an instance of {@link Listeprolongations }
     * 
     */
    public Listeprolongations createListeprolongations() {
        return new Listeprolongations();
    }

    /**
     * Create an instance of {@link SupprimerReservationsResponse }
     * 
     */
    public SupprimerReservationsResponse createSupprimerReservationsResponse() {
        return new SupprimerReservationsResponse();
    }

    /**
     * Create an instance of {@link RetourResponse }
     * 
     */
    public RetourResponse createRetourResponse() {
        return new RetourResponse();
    }

    /**
     * Create an instance of {@link EnvoyerRappel }
     * 
     */
    public EnvoyerRappel createEnvoyerRappel() {
        return new EnvoyerRappel();
    }

    /**
     * Create an instance of {@link SupprimerRappelResponse }
     * 
     */
    public SupprimerRappelResponse createSupprimerRappelResponse() {
        return new SupprimerRappelResponse();
    }

    /**
     * Create an instance of {@link USerReservationResponse }
     * 
     */
    public USerReservationResponse createUSerReservationResponse() {
        return new USerReservationResponse();
    }

    /**
     * Create an instance of {@link ReserverEnAvanceResponse }
     * 
     */
    public ReserverEnAvanceResponse createReserverEnAvanceResponse() {
        return new ReserverEnAvanceResponse();
    }

    /**
     * Create an instance of {@link SupprimerLivreResponse }
     * 
     */
    public SupprimerLivreResponse createSupprimerLivreResponse() {
        return new SupprimerLivreResponse();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Retour }
     * 
     */
    public Retour createRetour() {
        return new Retour();
    }

    /**
     * Create an instance of {@link ListAttente }
     * 
     */
    public ListAttente createListAttente() {
        return new ListAttente();
    }

    /**
     * Create an instance of {@link Inscription }
     * 
     */
    public Inscription createInscription() {
        return new Inscription();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link ListAttenteResponse }
     * 
     */
    public ListAttenteResponse createListAttenteResponse() {
        return new ListAttenteResponse();
    }

    /**
     * Create an instance of {@link Reserver }
     * 
     */
    public Reserver createReserver() {
        return new Reserver();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link Livre }
     * 
     */
    public Livre createLivre() {
        return new Livre();
    }

    /**
     * Create an instance of {@link Prolongerpret }
     * 
     */
    public Prolongerpret createProlongerpret() {
        return new Prolongerpret();
    }

    /**
     * Create an instance of {@link ConnexionResponse }
     * 
     */
    public ConnexionResponse createConnexionResponse() {
        return new ConnexionResponse();
    }

    /**
     * Create an instance of {@link Listedeslivres }
     * 
     */
    public Listedeslivres createListedeslivres() {
        return new Listedeslivres();
    }

    /**
     * Create an instance of {@link ConnexionEquipeResponse }
     * 
     */
    public ConnexionEquipeResponse createConnexionEquipeResponse() {
        return new ConnexionEquipeResponse();
    }

    /**
     * Create an instance of {@link ListerappelResponse }
     * 
     */
    public ListerappelResponse createListerappelResponse() {
        return new ListerappelResponse();
    }

    /**
     * Create an instance of {@link AjouterLivreResponse }
     * 
     */
    public AjouterLivreResponse createAjouterLivreResponse() {
        return new AjouterLivreResponse();
    }

    /**
     * Create an instance of {@link ProlongationsResponse }
     * 
     */
    public ProlongationsResponse createProlongationsResponse() {
        return new ProlongationsResponse();
    }

    /**
     * Create an instance of {@link Prolongations }
     * 
     */
    public Prolongations createProlongations() {
        return new Prolongations();
    }

    /**
     * Create an instance of {@link Supprimerprolongation }
     * 
     */
    public Supprimerprolongation createSupprimerprolongation() {
        return new Supprimerprolongation();
    }

    /**
     * Create an instance of {@link ListUser }
     * 
     */
    public ListUser createListUser() {
        return new ListUser();
    }

    /**
     * Create an instance of {@link ConnexionEquipe }
     * 
     */
    public ConnexionEquipe createConnexionEquipe() {
        return new ConnexionEquipe();
    }

    /**
     * Create an instance of {@link EnvoyerRappelResponse }
     * 
     */
    public EnvoyerRappelResponse createEnvoyerRappelResponse() {
        return new EnvoyerRappelResponse();
    }

    /**
     * Create an instance of {@link ListPretResponse }
     * 
     */
    public ListPretResponse createListPretResponse() {
        return new ListPretResponse();
    }

    /**
     * Create an instance of {@link Rappel }
     * 
     */
    public Rappel createRappel() {
        return new Rappel();
    }

    /**
     * Create an instance of {@link SupprimerLivre }
     * 
     */
    public SupprimerLivre createSupprimerLivre() {
        return new SupprimerLivre();
    }

    /**
     * Create an instance of {@link Connexion }
     * 
     */
    public Connexion createConnexion() {
        return new Connexion();
    }

    /**
     * Create an instance of {@link SupprimerRappel }
     * 
     */
    public SupprimerRappel createSupprimerRappel() {
        return new SupprimerRappel();
    }

    /**
     * Create an instance of {@link Prolongation }
     * 
     */
    public Prolongation createProlongation() {
        return new Prolongation();
    }

    /**
     * Create an instance of {@link USerReservation }
     * 
     */
    public USerReservation createUSerReservation() {
        return new USerReservation();
    }

    /**
     * Create an instance of {@link ProlongerpretResponse }
     * 
     */
    public ProlongerpretResponse createProlongerpretResponse() {
        return new ProlongerpretResponse();
    }

    /**
     * Create an instance of {@link Listerappel }
     * 
     */
    public Listerappel createListerappel() {
        return new Listerappel();
    }

    /**
     * Create an instance of {@link AjouterLivre }
     * 
     */
    public AjouterLivre createAjouterLivre() {
        return new AjouterLivre();
    }

    /**
     * Create an instance of {@link InscriptionResponse }
     * 
     */
    public InscriptionResponse createInscriptionResponse() {
        return new InscriptionResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link ReserverEnAvance }
     * 
     */
    public ReserverEnAvance createReserverEnAvance() {
        return new ReserverEnAvance();
    }

    /**
     * Create an instance of {@link Trouverlivre }
     * 
     */
    public Trouverlivre createTrouverlivre() {
        return new Trouverlivre();
    }

    /**
     * Create an instance of {@link TrouverlivreResponse }
     * 
     */
    public TrouverlivreResponse createTrouverlivreResponse() {
        return new TrouverlivreResponse();
    }

    /**
     * Create an instance of {@link SupprimerprolongationResponse }
     * 
     */
    public SupprimerprolongationResponse createSupprimerprolongationResponse() {
        return new SupprimerprolongationResponse();
    }

    /**
     * Create an instance of {@link Reservations }
     * 
     */
    public Reservations createReservations() {
        return new Reservations();
    }

    /**
     * Create an instance of {@link ReserverResponse }
     * 
     */
    public ReserverResponse createReserverResponse() {
        return new ReserverResponse();
    }

    /**
     * Create an instance of {@link ListedeslivresResponse }
     * 
     */
    public ListedeslivresResponse createListedeslivresResponse() {
        return new ListedeslivresResponse();
    }

    /**
     * Create an instance of {@link ListeprolongationsResponse }
     * 
     */
    public ListeprolongationsResponse createListeprolongationsResponse() {
        return new ListeprolongationsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listerappel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listerappel")
    public JAXBElement<Listerappel> createListerappel(Listerappel value) {
        return new JAXBElement<Listerappel>(_Listerappel_QNAME, Listerappel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerpretResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "prolongerpretResponse")
    public JAXBElement<ProlongerpretResponse> createProlongerpretResponse(ProlongerpretResponse value) {
        return new JAXBElement<ProlongerpretResponse>(_ProlongerpretResponse_QNAME, ProlongerpretResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ajouterLivre")
    public JAXBElement<AjouterLivre> createAjouterLivre(AjouterLivre value) {
        return new JAXBElement<AjouterLivre>(_AjouterLivre_QNAME, AjouterLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscriptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "inscriptionResponse")
    public JAXBElement<InscriptionResponse> createInscriptionResponse(InscriptionResponse value) {
        return new JAXBElement<InscriptionResponse>(_InscriptionResponse_QNAME, InscriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPretResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ListPretResponse")
    public JAXBElement<ListPretResponse> createListPretResponse(ListPretResponse value) {
        return new JAXBElement<ListPretResponse>(_ListPretResponse_QNAME, ListPretResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rappel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "rappel")
    public JAXBElement<Rappel> createRappel(Rappel value) {
        return new JAXBElement<Rappel>(_Rappel_QNAME, Rappel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "supprimerLivre")
    public JAXBElement<SupprimerLivre> createSupprimerLivre(SupprimerLivre value) {
        return new JAXBElement<SupprimerLivre>(_SupprimerLivre_QNAME, SupprimerLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionEquipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "connexionEquipe")
    public JAXBElement<ConnexionEquipe> createConnexionEquipe(ConnexionEquipe value) {
        return new JAXBElement<ConnexionEquipe>(_ConnexionEquipe_QNAME, ConnexionEquipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvoyerRappelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "envoyerRappelResponse")
    public JAXBElement<EnvoyerRappelResponse> createEnvoyerRappelResponse(EnvoyerRappelResponse value) {
        return new JAXBElement<EnvoyerRappelResponse>(_EnvoyerRappelResponse_QNAME, EnvoyerRappelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USerReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "USerReservation")
    public JAXBElement<USerReservation> createUSerReservation(USerReservation value) {
        return new JAXBElement<USerReservation>(_USerReservation_QNAME, USerReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "connexion")
    public JAXBElement<Connexion> createConnexion(Connexion value) {
        return new JAXBElement<Connexion>(_Connexion_QNAME, Connexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerRappel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "SupprimerRappel")
    public JAXBElement<SupprimerRappel> createSupprimerRappel(SupprimerRappel value) {
        return new JAXBElement<SupprimerRappel>(_SupprimerRappel_QNAME, SupprimerRappel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prolongation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "prolongation")
    public JAXBElement<Prolongation> createProlongation(Prolongation value) {
        return new JAXBElement<Prolongation>(_Prolongation_QNAME, Prolongation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reservations")
    public JAXBElement<Reservations> createReservations(Reservations value) {
        return new JAXBElement<Reservations>(_Reservations_QNAME, Reservations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reserverResponse")
    public JAXBElement<ReserverResponse> createReserverResponse(ReserverResponse value) {
        return new JAXBElement<ReserverResponse>(_ReserverResponse_QNAME, ReserverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrouverlivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "trouverlivreResponse")
    public JAXBElement<TrouverlivreResponse> createTrouverlivreResponse(TrouverlivreResponse value) {
        return new JAXBElement<TrouverlivreResponse>(_TrouverlivreResponse_QNAME, TrouverlivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerprolongationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "SupprimerprolongationResponse")
    public JAXBElement<SupprimerprolongationResponse> createSupprimerprolongationResponse(SupprimerprolongationResponse value) {
        return new JAXBElement<SupprimerprolongationResponse>(_SupprimerprolongationResponse_QNAME, SupprimerprolongationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListedeslivresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ListedeslivresResponse")
    public JAXBElement<ListedeslivresResponse> createListedeslivresResponse(ListedeslivresResponse value) {
        return new JAXBElement<ListedeslivresResponse>(_ListedeslivresResponse_QNAME, ListedeslivresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeprolongationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listeprolongationsResponse")
    public JAXBElement<ListeprolongationsResponse> createListeprolongationsResponse(ListeprolongationsResponse value) {
        return new JAXBElement<ListeprolongationsResponse>(_ListeprolongationsResponse_QNAME, ListeprolongationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trouverlivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "trouverlivre")
    public JAXBElement<Trouverlivre> createTrouverlivre(Trouverlivre value) {
        return new JAXBElement<Trouverlivre>(_Trouverlivre_QNAME, Trouverlivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverEnAvance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reserverEnAvance")
    public JAXBElement<ReserverEnAvance> createReserverEnAvance(ReserverEnAvance value) {
        return new JAXBElement<ReserverEnAvance>(_ReserverEnAvance_QNAME, ReserverEnAvance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "supprimerLivreResponse")
    public JAXBElement<SupprimerLivreResponse> createSupprimerLivreResponse(SupprimerLivreResponse value) {
        return new JAXBElement<SupprimerLivreResponse>(_SupprimerLivreResponse_QNAME, SupprimerLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Utilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "utilisateur")
    public JAXBElement<Utilisateur> createUtilisateur(Utilisateur value) {
        return new JAXBElement<Utilisateur>(_Utilisateur_QNAME, Utilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverEnAvanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reserverEnAvanceResponse")
    public JAXBElement<ReserverEnAvanceResponse> createReserverEnAvanceResponse(ReserverEnAvanceResponse value) {
        return new JAXBElement<ReserverEnAvanceResponse>(_ReserverEnAvanceResponse_QNAME, ReserverEnAvanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Retour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "Retour")
    public JAXBElement<Retour> createRetour(Retour value) {
        return new JAXBElement<Retour>(_Retour_QNAME, Retour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAttente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ListAttente")
    public JAXBElement<ListAttente> createListAttente(ListAttente value) {
        return new JAXBElement<ListAttente>(_ListAttente_QNAME, ListAttente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inscription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "inscription")
    public JAXBElement<Inscription> createInscription(Inscription value) {
        return new JAXBElement<Inscription>(_Inscription_QNAME, Inscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reservation")
    public JAXBElement<Reservation> createReservation(Reservation value) {
        return new JAXBElement<Reservation>(_Reservation_QNAME, Reservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listeprolongations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listeprolongations")
    public JAXBElement<Listeprolongations> createListeprolongations(Listeprolongations value) {
        return new JAXBElement<Listeprolongations>(_Listeprolongations_QNAME, Listeprolongations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerReservations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "SupprimerReservations")
    public JAXBElement<SupprimerReservations> createSupprimerReservations(SupprimerReservations value) {
        return new JAXBElement<SupprimerReservations>(_SupprimerReservations_QNAME, SupprimerReservations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ListPret")
    public JAXBElement<ListPret> createListPret(ListPret value) {
        return new JAXBElement<ListPret>(_ListPret_QNAME, ListPret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetourResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "RetourResponse")
    public JAXBElement<RetourResponse> createRetourResponse(RetourResponse value) {
        return new JAXBElement<RetourResponse>(_RetourResponse_QNAME, RetourResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvoyerRappel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "envoyerRappel")
    public JAXBElement<EnvoyerRappel> createEnvoyerRappel(EnvoyerRappel value) {
        return new JAXBElement<EnvoyerRappel>(_EnvoyerRappel_QNAME, EnvoyerRappel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerRappelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "SupprimerRappelResponse")
    public JAXBElement<SupprimerRappelResponse> createSupprimerRappelResponse(SupprimerRappelResponse value) {
        return new JAXBElement<SupprimerRappelResponse>(_SupprimerRappelResponse_QNAME, SupprimerRappelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USerReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "USerReservationResponse")
    public JAXBElement<USerReservationResponse> createUSerReservationResponse(USerReservationResponse value) {
        return new JAXBElement<USerReservationResponse>(_USerReservationResponse_QNAME, USerReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerReservationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "SupprimerReservationsResponse")
    public JAXBElement<SupprimerReservationsResponse> createSupprimerReservationsResponse(SupprimerReservationsResponse value) {
        return new JAXBElement<SupprimerReservationsResponse>(_SupprimerReservationsResponse_QNAME, SupprimerReservationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listedeslivres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "Listedeslivres")
    public JAXBElement<Listedeslivres> createListedeslivres(Listedeslivres value) {
        return new JAXBElement<Listedeslivres>(_Listedeslivres_QNAME, Listedeslivres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionEquipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "connexionEquipeResponse")
    public JAXBElement<ConnexionEquipeResponse> createConnexionEquipeResponse(ConnexionEquipeResponse value) {
        return new JAXBElement<ConnexionEquipeResponse>(_ConnexionEquipeResponse_QNAME, ConnexionEquipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListerappelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listerappelResponse")
    public JAXBElement<ListerappelResponse> createListerappelResponse(ListerappelResponse value) {
        return new JAXBElement<ListerappelResponse>(_ListerappelResponse_QNAME, ListerappelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prolongerpret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "prolongerpret")
    public JAXBElement<Prolongerpret> createProlongerpret(Prolongerpret value) {
        return new JAXBElement<Prolongerpret>(_Prolongerpret_QNAME, Prolongerpret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "connexionResponse")
    public JAXBElement<ConnexionResponse> createConnexionResponse(ConnexionResponse value) {
        return new JAXBElement<ConnexionResponse>(_ConnexionResponse_QNAME, ConnexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Supprimerprolongation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "Supprimerprolongation")
    public JAXBElement<Supprimerprolongation> createSupprimerprolongation(Supprimerprolongation value) {
        return new JAXBElement<Supprimerprolongation>(_Supprimerprolongation_QNAME, Supprimerprolongation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ajouterLivreResponse")
    public JAXBElement<AjouterLivreResponse> createAjouterLivreResponse(AjouterLivreResponse value) {
        return new JAXBElement<AjouterLivreResponse>(_AjouterLivreResponse_QNAME, AjouterLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "prolongationsResponse")
    public JAXBElement<ProlongationsResponse> createProlongationsResponse(ProlongationsResponse value) {
        return new JAXBElement<ProlongationsResponse>(_ProlongationsResponse_QNAME, ProlongationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prolongations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "prolongations")
    public JAXBElement<Prolongations> createProlongations(Prolongations value) {
        return new JAXBElement<Prolongations>(_Prolongations_QNAME, Prolongations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAttenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "ListAttenteResponse")
    public JAXBElement<ListAttenteResponse> createListAttenteResponse(ListAttenteResponse value) {
        return new JAXBElement<ListAttenteResponse>(_ListAttenteResponse_QNAME, ListAttenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Livre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "livre")
    public JAXBElement<Livre> createLivre(Livre value) {
        return new JAXBElement<Livre>(_Livre_QNAME, Livre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsService.ws.oc.com/", name = "reserver")
    public JAXBElement<Reserver> createReserver(Reserver value) {
        return new JAXBElement<Reserver>(_Reserver_QNAME, Reserver.class, null, value);
    }

}
