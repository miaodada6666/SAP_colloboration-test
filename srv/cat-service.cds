using my.company as my from '../db/data-model';


service CatalogService {
    //entity Collaborationtype as projection on my.CollaborationType;
    entity StatusProfile as projection on my.StatusProfile;
    action setToUse(ID:String,description:String);
}