		fileUpload.add(new AbstractValidator<FileUpload>() {
			private static final long serialVersionUID = 1L;

			protected void onValidate(IValidatable<FileUpload> validatable) {
				FileUpload fileUpload = validatable.getValue();
				String type = FilenameUtils.getExtension(fileUpload.getClientFileName());

				if (type.equals("csv"))
					showError(validatable, "CSV File uploaded");
				else
					showError(validatable, "Sorry, only CSV Files supported");

			}

			private void showError(IValidatable<FileUpload> validatable, String errorKey) {
				validatable.error(new ValidationError().setMessage(errorKey));
			}
		});
