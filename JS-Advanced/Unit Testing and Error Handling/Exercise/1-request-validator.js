const request1 = {
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
};

console.log(validateRequest(request1));

const request2 = {
    method: 'OPTIONS',
    uri: 'git.master',
    version: 'HTTP/1.1',
    message: '-recursive'  
};

console.log(validateRequest(request2));



function validateRequest(request) {

  if (!isValidMethod(request?.method)) {
    throw Error('Invalid request header: Invalid Method');
  }

  if (!isValidURI(request?.uri)) {
    throw Error('Invalid request header: Invalid URI');
  }

  if(!isValidVersion(request?.version)) {
    throw Error('Invalid request header: Invalid Version')
  }

  if (!isValidMessage(request?.message)) {
    throw Error('Invalid request header: Invalid Message');
  }

  return request;
}

function isValidMethod(method) {
    const validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];

    return validMethods.includes(method);
}

function isValidURI(uri) {
    const regex = /^([a-zA-Z0-9]+(\.[a-zA-Z0-9]+)*)|\*$/;

    return uri !== "" && regex.test(uri);
}

function isValidVersion(version) {
    const validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

    return validVersions.includes(version);
}

function isValidMessage(message) {
    const regex = /^[^<>\\&'"]*$/;

    return regex.test(message);
}

