from wa import Parameter, ApkUiautoWorkload


class Calculator(ApkUiautoWorkload):

    name = 'calculator'
    description = "This is an placeholder description"
    # Replace with a list of supported package names in the APK file(s).
    package_names = ['package_name']

    parameters = [
        # Workload parameters go here e.g.
        Parameter('example_parameter', kind=int, allowed_values=[1,2,3],
                  default=1, override=True, mandatory=False,
                  description='This is an example parameter')
    ]

    def __init__(self, target, **kwargs):
        super(Calculator, self).__init__(target, **kwargs)
        # Define any additional attributes required for the workload

    def init_resources(self, resolver):
        super(Calculator, self).init_resources(resolver)
        # This method may be used to perform early resource discovery and
        # initialization. This is invoked during the initial loading stage and
        # before the device is ready, so cannot be used for any device-dependent
        # initialization. This method is invoked before the workload instance is
        # validated.

    def initialize(self, context):
        super(Calculator, self).initialize(context)
        # This method should be used to perform once-per-run initialization of a
        # workload instance.

    def validate(self):
        super(Calculator, self).validate()
        # Validate inter-parameter assumptions etc

    def setup(self, context):
        super(Calculator, self).setup(context)
        # Perform any necessary setup before starting the UI automation

    def setup_rerun(self, context):
        super(Calculator, self).setup(context)
        # If the workloads has the `requires_rerun` attribute set to `True` this
        # method may be used to perform any necessary setup for the rerun of the
        # application.

    def extract_results(self, context):
        super(Calculator, self).extract_results(context)
        # Extract results on the target

    def update_output(self, context):
        super(Calculator, self).update_output(context)
        # Update the output within the specified execution context with the
        # metrics and artifacts form this workload iteration.

    def teardown(self, context):
        super(Calculator, self).teardown(context)
        # Perform any final clean up for the Workload.
