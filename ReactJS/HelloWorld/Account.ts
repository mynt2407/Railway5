export class Account {
    private static counter: number = 0;  

    private accountId: number;
    private email: string;
    private username: String;
    private fullname: String;
    private departmentId: number;
    private positionId: number;
    private createDate: Date;


	constructor(email: string, username: String, fullname: String, departmentId: number, positionId: number, createDate: Date) {
		this.accountId = ++Account.counter;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.departmentId = departmentId;
		this.positionId = positionId;
		this.createDate = createDate;
	}

    /**
     * Getter accountId
     * @return {number}
     */
	public getAccountId(): number {
		return this.accountId;
	}

    /**
     * Getter email
     * @return {string}
     */
	public getEmail(): string {
		return this.email;
	}

    /**
     * Getter username
     * @return {String}
     */
	public getUsername(): String {
		return this.username;
	}

    /**
     * Getter fullname
     * @return {String}
     */
	public getFullname(): String {
		return this.fullname;
	}

    /**
     * Getter departmentId
     * @return {number}
     */
	public getDepartmentId(): number {
		return this.departmentId;
	}

    /**
     * Getter positionId
     * @return {number}
     */
	public getPositionId(): number {
		return this.positionId;
	}

    /**
     * Getter createDate
     * @return {Date}
     */
	public getCreateDate(): Date {
		return this.createDate;
	}

    /**
     * Setter accountId
     * @param {number} value
     */
	public setAccountId(value: number) {
		this.accountId = value;
	}

    /**
     * Setter email
     * @param {string} value
     */
	public setEmail(value: string) {
		this.email = value;
	}

    /**
     * Setter username
     * @param {String} value
     */
	public setUsername(value: String) {
		this.username = value;
	}

    /**
     * Setter fullname
     * @param {String} value
     */
	public setFullname(value: String) {
		this.fullname = value;
	}

    /**
     * Setter departmentId
     * @param {number} value
     */
	public setDepartmentId(value: number) {
		this.departmentId = value;
	}

    /**
     * Setter positionId
     * @param {number} value
     */
	public setPositionId(value: number) {
		this.positionId = value;
	}

    /**
     * Setter createDate
     * @param {Date} value
     */
	public setCreateDate(value: Date) {
		this.createDate = value;
	}


}