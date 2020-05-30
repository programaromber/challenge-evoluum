package br.com.evoluum.challenge.api.exceptionhandler;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;

import br.com.evoluum.challenge.domain.exception.BussinesException;
import br.com.evoluum.challenge.infrastructure.service.SourceService;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	
	private static final Logger LOG = LoggerFactory.getLogger(SourceService.class);
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.status(status).headers(headers).build();
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		
		return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

	    return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
	}

	private ResponseEntity<Object> handleValidationInternal(Exception ex, HttpHeaders headers,
			HttpStatus status, WebRequest request, BindingResult bindingResult) {
		ProblemType problemType = ProblemType.INVALID_DATA;
	    String detail = "One or more invalid fields.";
	    final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage()); 
	    return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;		
		ProblemType problemType = ProblemType.SYSTEM_ERROR;
		String detail = "error occurred";

		LOG.error(ex.getMessage(), ex);
		
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
		String detail = String.format("Resource %s not found.", 
				ex.getRequestURL());
		
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (ex instanceof MethodArgumentTypeMismatchException) {
			return handleMethodArgumentTypeMismatch(
					(MethodArgumentTypeMismatchException) ex, headers, status, request);
		}
	
		return super.handleTypeMismatch(ex, headers, status, request);
	}
	
	private ResponseEntity<Object> handleMethodArgumentTypeMismatch(
			MethodArgumentTypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ProblemType problemType = ProblemType.INVALD_PARAMETER;

		String detail = String.format("Invalid parameter '%s' for '%s', required type %s.",
				ex.getValue(), ex.getName(), ex.getRequiredType().getSimpleName());

		LOG.error(ex.getMessage(), ex);
		
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());

		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Throwable rootCause = ExceptionUtils.getRootCause(ex);
		
		if (rootCause instanceof InvalidFormatException) {
			return handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
		} else if (rootCause instanceof PropertyBindingException) {
			return handlePropertyBinding((PropertyBindingException) rootCause, headers, status, request); 
		}
		
		ProblemType problemType = ProblemType.GENERIC_ERROR;
		String detail = "Invalid request body.";
		
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	private ResponseEntity<Object> handlePropertyBinding(PropertyBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String path = joinPath(ex.getPath());
		
		ProblemType problemType = ProblemType.GENERIC_ERROR;
		String detail = String.format("Propertie '%s' not foudn.", path);

		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, headers, status, request);
	}
	
	private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String path = joinPath(ex.getPath());
		
		ProblemType problemType = ProblemType.GENERIC_ERROR;
		String detail = String.format("Invalid propertie '%s' for '%s', required type %s.",
				 ex.getValue(), path, ex.getTargetType().getSimpleName());
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, headers, status, request);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontrada(EntityNotFoundException ex,
			WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
		String detail = ex.getMessage();
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	
	@ExceptionHandler(BussinesException.class)
	public ResponseEntity<?> handleNegocio(BussinesException ex, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.BUSSINES_ERROR;
		String detail = ex.getMessage();
		
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), problemType.getUri(), detail, ex.getLocalizedMessage());
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		LOG.error(ex.getMessage(), ex);
		final Problem problem = new Problem(status.value(), OffsetDateTime.now(), null, null, ex.getLocalizedMessage());
		return super.handleExceptionInternal(ex, problem, headers, status, request);
	}
	

	private String joinPath(List<Reference> references) {
		return references.stream()
			.map(ref -> ref.getFieldName())
			.collect(Collectors.joining("."));
	}
	
}
