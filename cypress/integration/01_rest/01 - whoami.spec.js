/// <reference types="cypress" />

describe('whoami endpoint', () => {
  it(`should return valid json with
    + language,
    + user agent
    + IP Address`, () => {
    cy.request({
      url: "/plugins/servlet/requestheaderparser/api/whoami",
      headers: {
        "Accept-Language": "en-GB",
        "user-agent": "cypress-browser"
      },
    }).then(response => {
      const body = response.body;
      console.log("body: ", body);
      expect(body.ipAddress).to.not.be.undefined;
      expect(body.language).to.equal("en-GB");
      expect(body.software).to.equal("cypress-browser");
    });
  });
});
