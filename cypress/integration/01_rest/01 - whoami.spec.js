/// <reference types="cypress" />

describe('whoami endpoint', () => {
  it("should return 200", () => {
    // cy.request("/plugins/servlet/helloworld");
    cy.request("/plugins/servlet/requestheaderparser/api/whoami");
    
  });
});
