namespace my.bookshop;

entity CollaborationType {
  key ID : String;
  key version : Integer;
  description: String;
  profile: Association to StatusProfile;
  state : Integer;
}
entity StatusProfile{
	key ID: String;
	description: String;
}

