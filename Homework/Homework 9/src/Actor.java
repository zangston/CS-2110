/**
 * The Actor class represents a person in the IMDB database of actors.
 *  
 * @author Your friendly CS Professors
 *
 */
class Actor implements Comparable<Actor> {
		String nconst;
		String primaryName;
		String birthYear;
		String deathYear;
		String primaryProfession;
		String knownForTitles;
		/**
		 * default constructor
		 */
		public Actor() {
			
		}
		/**
		 * useful for testing
		 * @param name
		 */
		public Actor(String name) {
			this.primaryName=name;
		}
		/**
		 * overloaded constructor
		 * @param nconst
		 * @param primaryName
		 * @param birthYear
		 * @param deathYear
		 * @param primaryProfession
		 * @param knownForTitles
		 */
		public Actor (String nconst, String primaryName, String birthYear, String deathYear, String primaryProfession, String knownForTitles) {
			this.nconst = nconst;
			this.primaryName = primaryName;
			this.birthYear = birthYear;
			this.deathYear = deathYear;
			this.primaryProfession=primaryProfession;
			this.knownForTitles=knownForTitles;
		}
		/**
		 * Actors will simply be compared by name
		 */
		@Override
		public boolean equals(Object o) {
			if (o== null) {
				return false;
			}
			if (!(o instanceof Actor)) {
				return false;
			}
			Actor otherActor = (Actor) o;
			if (this.primaryName.equals(otherActor.primaryName) ) {			
				return true;
			} else {
				return false;
			}
		}
		/**
		 *  Actors will be naturally sorted by name
		 */
		@Override
		public int compareTo(Actor a) {
			return this.primaryName.compareTo(a.primaryName);
		}
		
		/**
		 * @return the nconst
		 */
		public String getNconst() {
			return nconst;
		}
		/**
		 * @param nconst the nconst to set
		 */
		public void setNconst(String nconst) {
			this.nconst = nconst;
		}
		/**
		 * @return the primaryName
		 */
		public String getPrimaryName() {
			return primaryName;
		}
		/**
		 * @param primaryName the primaryName to set
		 */
		public void setPrimaryName(String primaryName) {
			this.primaryName = primaryName;
		}
		/**
		 * @return the birthYear
		 */
		public String getBirthYear() {
			return birthYear;
		}
		/**
		 * @param birthYear the birthYear to set
		 */
		public void setBirthYear(String birthYear) {
			this.birthYear = birthYear;
		}
		/**
		 * @return the deathYear
		 */
		public String getDeathYear() {
			return deathYear;
		}
		/**
		 * @param deathYear the deathYear to set
		 */
		public void setDeathYear(String deathYear) {
			this.deathYear = deathYear;
		}
		/**
		 * @return the primaryProfession
		 */
		public String getPrimaryProfession() {
			return primaryProfession;
		}
		/**
		 * @param primaryProfession the primaryProfession to set
		 */
		public void setPrimaryProfession(String primaryProfession) {
			this.primaryProfession = primaryProfession;
		}
		/**
		 * @return the knownForTitles
		 */
		public String getKnownForTitles() {
			return knownForTitles;
		}
		/**
		 * @param knownForTitles the knownForTitles to set
		 */
		public void setKnownForTitles(String knownForTitles) {
			this.knownForTitles = knownForTitles;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Actor [nconst=" + nconst + ", primaryName=" + primaryName + ", birthYear=" + birthYear
					+ ", deathYear=" + deathYear + ", primaryProfession=" + primaryProfession + ", knownForTitles="
					+ knownForTitles + "]";
		}
		
			
		
	}